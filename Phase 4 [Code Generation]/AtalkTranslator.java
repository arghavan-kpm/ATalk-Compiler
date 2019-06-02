import java.util.*;
import java.io.*;



public class AtalkTranslator {

    private File output;
    private ArrayList <String> instructions;
    private ArrayList <String> initInstructions;
    private int GlobalSum = 0;
    private PrintWriter writer;
    private int MaxMesg = 0;
    private ArrayList ActorSize;

    public AtalkTranslator(){
        instructions = new ArrayList<String>();
        initInstructions = new ArrayList<String>();
        output = new File("out.asm");
        try {
            output.createNewFile();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addSystemCall(int x){
        instructions.add("# start syscall " + x);
        instructions.add("li $v0, " + x);
        instructions.add("syscall");
        instructions.add("# end syscall");
    }		//SP won't change
    /// when getting out of receiver , we have to move $sp, $fp

    public void setMaxMesg( int Maxmesg){
    	MaxMesg = Maxmesg;
    }

    public void makeOutput(ArrayList Actorsize, ArrayList initInd, int MaxMesgSize,int RecvCnt){
    	MaxMesg = MaxMesgSize;
        this.addSystemCall(10);
        try {
            writer = new PrintWriter(output);
            writer.println(".data");
            writer.println("Excep1:       .asciiz \" arr index out of range !\"");
            writer.println("Excep2:       .asciiz \" Actor Buffer overflow !\"");
            writer.println(".text");

            writer.println("main:");
            writer.println("move $fp, $sp"); // what is it ?
            writer.println("move $t9, $sp");
            writer.println("li $t8, 0"); // RR ind cleared
            writer.println("li $t7, 0"); // actor ha payam nadarand
            for (int i=0;i<initInstructions.size();i++){
                writer.println(initInstructions.get(i));
            }
            ActorSize = Actorsize;
            initial(GlobalSum + 4,  initInd);

            scheduler(RecvCnt);

            for (int i=0;i<instructions.size();i++){
                writer.println(instructions.get(i));
            }
            
            writer.println("IndexOutOfRange:");
            writer.println("li $v0, 4");
            writer.println("la $a0, Excep1");
            writer.println("syscall");
            writer.println("j END_PROG");

            writer.println("ActorBufferOverFlow:");
            writer.println("li $v0, 4");
            writer.println("la $a0, Excep2");
            writer.println("syscall");
            writer.println("j END_PROG");
            writer.println("END_PROG:");
  			writer.println("li $v0, 10" );
        	writer.println("syscall");
            writer.close();

        } catch (Exception e) { e.printStackTrace(); }
    }		//SP won't change

    private void initial(int offset, ArrayList initInd){
    	writer.println("# start of initializing queues");
    	
    	for(int i=0; i < ActorSize.size(); i++){
    		if(Integer.parseInt(initInd.get(i).toString()) == 0)
    			writer.println("li $a0, 0"); // init() nadarad
    		else
    			writer.println("li $a0, 1");

    		writer.println("sw $a0, " + offset + "($gp)");
    		writer.println("li $a0, 0");
    		writer.println("sw $a0, " + String.format("%d", offset + 4) + "($gp)");
    		offset += 8;
    	}
    	for(int i=0; i<ActorSize.size(); i++){// payam haye init ra dar saf e actor ha mizarim
    		writer.println("li $a0, " + initInd.get(i));
    		writer.println("sw $a0, " + offset + "($gp)");
    		offset += MaxMesg* Integer.parseInt(ActorSize.get(i).toString()); // b saf e actor e baD miravim
    	}
    	writer.println("# end of initializing queues");
    }

    private void scheduler(int RecvCnt){
    	writer.println("SCHEDULER:");	
    	writer.println("move $sp, $fp"); // what is it ?
        writer.println("move $t9, $sp");
		for(int i=0;i < ActorSize.size();i++){
			writer.println("li $a0, " + i);
			writer.println("beq $t8, $a0, ACTOR_" + i);
		}
		for(int i=0;i < ActorSize.size();i++){
			writer.println("ACTOR_" + i + ":");
			writer.println("lw $a0, " + String.format("%d", GlobalSum + 4 + 8*i) + "($gp)"); // tedad payam ha
			writer.println("li $t0," +  ActorSize.size());
			writer.println("sltu $t7 , $zero, $a0");
			writer.println("addiu $t8, $t8, 1");
	    	writer.println("rem $t8, $t8, $t0");

	    	writer.println("or $t2, $t7, $t8");
	    	writer.println("beqz $t2 END_PROG"); // barname tamam shode
	    	
	    	writer.println("bgtz $t8,CONTINUE_" + i);
	    	writer.println("li $t7, 0");
	    	writer.println("CONTINUE_" + i + ":");
	    
			writer.println("beqz $a0 SCHEDULER");
			int sum = GlobalSum + 4 + 8*ActorSize.size() ;
    		for(int j=0; j< i; j++){
    			sum += MaxMesg * Integer.parseInt( ActorSize.get(j).toString());
    		}
    		writer.println("li $t1, " + sum); 
    		writer.println("add $t1, $t1, $gp"); // start of Q

    		writer.println("lw $t2, " + String.format("%d", GlobalSum + 4 + 8*i + 4) + "($gp)"); //startPointer
			writer.println("li $t3, " + MaxMesg);
			writer.println("mul $t2, $t3, $t2");
			writer.println("add $t1, $t1, $t2");
			writer.println("lw $t1, 0($t1)"); //shomare e recv E k bayad anjam shavad
			writer.println("j BRANCHES");
		}

		writer.println("BRANCHES:");
		for(int i=1; i<=RecvCnt; i++){
			writer.println("li $a0, " + i);
			writer.println("beq $t1, $a0, RECV_" + i);
		}

    } 

    public void add2Q(ArrayList actorSize,int actNum, int recvNum, ArrayList argType){
    	ActorSize = new ArrayList(actorSize);
    	instructions.add("# start of adding mesg to Q");
 
    	instructions.add("lw $a0, " + String.format("%d", GlobalSum + 4 + 8*actNum) + "($gp)");
    	
    	instructions.add("li $t0, " + Integer.parseInt(ActorSize.get(actNum).toString())); // tedad e payam haye saf

    	instructions.add("beq $a0, $t0, ActorBufferOverFlow");
    	int sum = GlobalSum + 4 + 8*ActorSize.size() ;
    	for(int i=0; i< actNum; i++){
    		sum += MaxMesg * Integer.parseInt( ActorSize.get(i).toString());
    	}
    	instructions.add("li $t1, " + sum); // start of Q
    	instructions.add("lw $t2, " + String.format("%d", GlobalSum + 4 + 8*actNum + 4) + "($gp)"); //startPointer
    	instructions.add("add $t2, $t2, $a0");
    	instructions.add("rem $t0, $t2, $t0");
    	instructions.add("li $t3, " + MaxMesg);
    	instructions.add("mul $t0, $t0, $t3");
    	instructions.add("add $t1, $t1, $t0"); // addr e jayi k bayd payam neveshte shavad
    	instructions.add("addiu $a0, $a0, 1");
    	instructions.add("sw $a0, " + String.format("%d", GlobalSum + 4 + 8*actNum) + "($gp)");
    
    	instructions.add("li $a0, " + recvNum);
    	instructions.add("addu $t1, $t1, $gp"); 
    	instructions.add("sw $a0, 0($t1)");// shomare recv dar payam zakhire shodi

    	int argsSum = 0;
    	for(int i=0; i < argType.size(); i++){
    		Type tmp = (Type)argType.get(i);
    		argsSum +=  tmp.size();
    	}

    	for(int i=argType.size()-1;i >= 0;i--){
    		Type tmp = (Type)argType.get(i);
    		if(tmp.size() == 4){
    			instructions.add("lw $a0, 4($sp)");
    			instructions.add("sw $a0, " + argsSum + "($t1)");
    			instructions.add("addiu $sp, $sp, 4");
    		}
    		else{
    			for(int j=tmp.size()/4 - 1; j >=0; j--){
    				instructions.add("lw $a0, 4($sp)");
    				instructions.add("sw $a0, " + String.format("%d", argsSum - j*4) + "($t1)");
    				instructions.add("addiu $sp, $sp, 4");
    			}
    		}
    		argsSum -= tmp.size();
    	}
    	
    	instructions.add("# end of adding mesg to Q");
    }

    public void loadFromQ(ArrayList actorSize,int actNum, int argSize, Type argType){
    	ActorSize = new ArrayList(actorSize);
    	instructions.add("# start of loading mesg from Q");
    	instructions.add("lw $a0, " + String.format("%d", GlobalSum + 4 + 8*actNum) + "($gp)"); // tedad e payam haye saf

    	int sum = GlobalSum + 4 + 8*ActorSize.size();
    	for(int i=0; i< actNum; i++){
    		sum += MaxMesg * Integer.parseInt( ActorSize.get(i).toString());
    	}

    	instructions.add("li $t1, " + sum); 
    	instructions.add("add $t1, $t1, $gp");// start of Q
    	instructions.add("lw $t2, " + String.format("%d", GlobalSum + 4 + 8*actNum + 4) + "($gp)"); //startPointer
    	instructions.add("li $t3, " + MaxMesg);
    	instructions.add("mul $t2, $t3, $t2");
    	instructions.add("add $t1, $t1, $t2"); // addr e jayi k bayd payam khande shavad
    	

    	for(int i=argType.size()/4-1 ; i>= 0; i--){
    		instructions.add("lw $t0, " + String.format("%d", 4 + i*4 + argSize) + "($t1)");
    		instructions.add("sw $t0, 0($sp)");
    		instructions.add("addiu $sp, $sp, -4");
    	}



    	instructions.add("# end of loading mesg from Q");
    }

    public void loadFromQ(ArrayList actorSize,int actNum){
    	ActorSize = new ArrayList(actorSize);
    	instructions.add("# start of loading mesg from Q");
    	instructions.add("lw $a0, " + String.format("%d", GlobalSum + 4 + 8*actNum) + "($gp)"); // tedad e payam haye saf
    	instructions.add("addiu $a0, $a0, -1");
    	instructions.add("sw $a0, " + String.format("%d", GlobalSum + 4 + 8*actNum) + "($gp)"); //updating $a0

    	instructions.add("lw $t2, " + String.format("%d", GlobalSum + 4 + 8*actNum + 4) + "($gp)"); 
    	instructions.add("addiu $t2,$t2 , 1");
    	instructions.add("li $t0," + ActorSize.size());
    	instructions.add("rem $t2,$t2,$t0");
    	instructions.add("sw $t2, " + String.format("%d", GlobalSum + 4 + 8*actNum + 4) + "($gp)"); //updating startpointer
    	instructions.add("# end of loading mesg from Q");
    }

    public void readStr(int num){
    	instructions.add("# start of reading ");
    	instructions.add("addiu $sp, $sp, " + String.format("%d", -1*num*4));
    	for(int i=0; i<num; i++){
    		this.addSystemCall(12); //read_char
    		instructions.add("sw $v0, " + String.format("%d", i*4 + 4) + "($sp)");
    	}
    	instructions.add("# end of reading ");
    }		// one above the stack top 

    public void write(Type type){
    	int Syscall = 11;
    	if(type instanceof IntType)
    		Syscall = 1;

    	instructions.add("#start of writing");
    	for(int i=0; i<type.size()/4; i++){
    		instructions.add("lw $a0, 4($sp)");
    		this.addSystemCall(Syscall);
    		instructions.add("addiu $sp, $sp, 4");
    	}

    	instructions.add("addi $a0, $zero, 10"); // \n
        this.addSystemCall(11);
        
    	instructions.add("#end of writing");
    }		// one above the stack top

    public void arrange(Type type, int cnt){
    	instructions.add("#start of arranging const arr");
    	for(int i=0;i < cnt/2;i++){
    		for(int j=0;j < type.size()/4;j++){
    			int param1 = type.size()*i + j*4 + 4;
    			int param2 = type.size()*(cnt - i - 1) + 4*j + 4;
    			instructions.add("lw $a0," + String.format("%d",param1) + "($sp)");
    			instructions.add("lw $t0," + String.format("%d",param2) + "($sp)");
    			instructions.add("sw $a0," + String.format("%d",param2) + "($sp)");
    			instructions.add("sw $t0," + String.format("%d",param1) + "($sp)");

    		}
    	}
    	instructions.add("#end of arranging const arr");
    }	// stack wont change

    public void notVarCommand(String op){
    	instructions.add("# start of making negative ");
    	instructions.add("lw $a0, 4($sp)");
    	if(op.equals("not") == true){
    		instructions.add("sltu $t0, $zero, $a0");
    		instructions.add("li $a0, 1");
    		instructions.add("sub $a0, $a0, $t0");
    	}
    		

    	if(op.equals("-") == true){
    		instructions.add("li $t0, -1");
    		instructions.add("mul $a0, $a0, $t0");
    	}
    	instructions.add("sw $a0, 4($sp)");
    	instructions.add("# end of making negative ");
    }		//stack won't change

    public void addrMultCommand(String op){
    	String str = "div";
    	if(op.equals("*" ) == true)
    		str = "mul";

    	instructions.add("# start of multiplying addr  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k addr ast
    	instructions.add("lw $t0, 0($t0)");//mohtavaye top -1
    	instructions.add(str + " $a0, $a0, $t0");
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of multiplying addr  ");
    }	// one above the stack top

    public void constMultCommand(String op){
    	String str = "div";
    	if(op.equals("*" ) == true)
    		str = "mul";

    	instructions.add("# start of multiplying const  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k const ast
    	instructions.add(str + " $a0, $a0, $t0");
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of multiplying const  ");
    }	// one above the stack top

    public void addrAddCommand(String op){
    	String str = "sub";
    	if(op.equals("+" ) == true)
    		str = "add";

    	instructions.add("# start of adding addr  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k addr ast
    	instructions.add("lw $t0, 0($t0)");//mohtavaye top -1
    	instructions.add(str + " $a0, $a0, $t0");
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of adding addr  ");
    }	// one above the stack top

    public void constAddCommand(String op){
    	String str = "sub";
    	if(op.equals("+" ) == true)
    		str = "add";

    	instructions.add("# start of adding const  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k const ast
    	instructions.add(str + " $a0, $a0, $t0");
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of adding const  ");
    }	// one above the stack top

    public void addrCmpCommand(String op){
    	String str = "$t0, $a0";
    	if(op.equals(">") == true)
    		str = "$a0, $t0";

    	instructions.add("# start of comparing addr  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k addr ast
    	instructions.add("lw $t0, 0($t0)");//mohtavaye top -1
    	instructions.add("slt $a0, " + str);
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of comparing addr  ");
    }	//one above the stack top

    public void constCmpCommand(String op){
    	String str = "$t0, $a0";
    	if(op.equals(">") == true)
    		str = "$a0, $t0";
    	instructions.add("# start of comparig const  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k const ast
    	instructions.add("slt $a0, " + str);
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of comparig const  ");
    }	//one above the stack top

    public void addrEqCommand(String op, Type type){
    	instructions.add("# start of finding eq or ne addr  ");
    	instructions.add("lw $t4, " + String.format("%d", type.size() + 4) + "($sp)"); // addr e Lvalue
    	instructions.add("li $a0, 0"); // meyar
    	for(int i=0; i<type.size()/4; i++){
    		instructions.add("lw $t0, " + String.format("%d", i*4 + 4) + "($sp)"); // Rvalue
    		instructions.add("lw $t1, " + String.format("%d",  i*4) + "($t4)");  // const e Lvalue
    		instructions.add("sub $t2, $t1, $t0");
    		instructions.add("sltu $t2, $zero, $t2");
    		instructions.add("or $a0, $a0, $t2"); //zakhire naTje ta alan
    	}

    	instructions.add("addiu $sp, $sp, " + String.format("%d", type.size() + 4));
    	if(op.equals("==") == true){
    		instructions.add("li $t3, 1");
    		instructions.add("sub $a0, $t3, $a0");
    	}
    	instructions.add("sw $a0, 0($sp)");
    	instructions.add("addiu $sp, $sp, -4");
    	
    	instructions.add("# end of finding eq or ne addr  ");
    }	// one above the stack top

    public void constEqCommand(String op, Type type){
    	instructions.add("# start of finding eq or ne const  ");
    	instructions.add("li $a0, 0"); // meyar
    	for(int i=0; i<type.size()/4; i++){
    		instructions.add("lw $t0, " + String.format("%d", i*4 + 4) + "($sp)"); // Rvalue
    		instructions.add("lw $t1, " + String.format("%d", type.size() + i*4 + 4) + "($sp)");  // Lvalue
    		instructions.add("sub $t2, $t1, $t0");
    		instructions.add("sltu $t2, $zero, $t2");
    		instructions.add("or $a0, $a0, $t2"); //zakhire naTje ta alan
    	}

    	instructions.add("addiu $sp, $sp, " + String.format("%d", 2*type.size()));
    	if(op.equals("==") == true){
    		instructions.add("li $t3, 1");
    		instructions.add("sub $a0, $t3, $a0");
    	}
    	instructions.add("sw $a0, 0($sp)");
    	instructions.add("addiu $sp, $sp, -4");

    	instructions.add("# end of finding eq or ne const  ");
    }	//one above the stack top

    public void addrAndCommand(){
    	instructions.add("# start of anding addr  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k addr ast
    	instructions.add("lw $t0, 0($t0)");//mohtavaye top -1
    	instructions.add("and $a0, $a0, $t0");
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of anding addr  ");
    }	//one above the stack top

    public void constAndCommand(){
    	instructions.add("# start of anding const  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k const ast
    	instructions.add("and $a0, $a0, $t0");
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of anding const  ");
    }	// one above the stack top

    public void addrOrCommand(){
    	instructions.add("# start of oring addr  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k addr ast
    	instructions.add("lw $t0, 0($t0)");//mohtavaye top -1
    	instructions.add("or $a0, $a0, $t0");
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of oring addr  ");
    }	// one above the stack top

    public void constOrCommand(){
    	instructions.add("# start of oring const  ");
    	instructions.add("lw $a0, 4($sp)");//sar e stack
    	instructions.add("lw $t0, 8($sp)");//top - 1 k const ast
    	instructions.add("or $a0, $a0, $t0");
    	instructions.add("sw $a0, 8($sp)");
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("# end of oring const  ");
    }	// one above the stack top

    public void assignCommand(Type type){
    	instructions.add("#start of assigning");
    	instructions.add("lw $a0, " + String.format("%d", type.size() + 4) + "($sp)");
    	for(int i=0; i<type.size()/4; i++){
    		instructions.add("lw $t0, 4($sp)");
    		instructions.add("sw $t0," +  String.format("%d", 4*i) + "($a0)");
    		instructions.add("addiu $sp, $sp, 4");
    	}

    	instructions.add("#end of assigning");
    }	//one above the stack top

    public void ifChecking(int cnt){
    	instructions.add("# start of if checking");
    	instructions.add("lw $a0, 4($sp)"); // naTje shart ra dar $a0 negah dashTm
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("beqz $a0, NOT_IF_" + cnt); 
    	instructions.add("# end of if checking");
    }

    public void ifEnd(int cnt){
    	instructions.add("# start of jumping to after if");
    	instructions.add("j END_IF_" + cnt);
    	instructions.add("# end of jumping to after if");
    }

    public void putNotIf_NotElseIf(int ifCnt, int elseIfCnt){
    	instructions.add("# start of putNotIf or NotElseIf Label");
    	if(elseIfCnt == 0)
    		instructions.add("NOT_IF_" + ifCnt + ":");
    	else
    		instructions.add("NOT_ELSE_IF_" + ifCnt + "_" + elseIfCnt + ":");

    	instructions.add("# end of putNotIf or NotElseIf Label");
    }

    public void elseifChecking(int ifCnt, int elseIfCnt){
    	instructions.add("# start of elseif checking");
    	instructions.add("lw $a0, 4($sp)"); // naTje shart ra dar $a0 negah dashTm
    	instructions.add("addiu $sp, $sp, 4");
    	instructions.add("beqz $a0, NOT_ELSE_IF_" + ifCnt + "_" + elseIfCnt); 
    	instructions.add("# end of elseif checking");
    }

    public void putEndIf(int ifCnt){
    	instructions.add("# start of after if or else ifs");
    	instructions.add("END_IF_" + ifCnt + ":");
    	instructions.add("# end of after if or else ifs");
    }

    public void beginBlock(){
    	instructions.add("# start of begin block");
    	instructions.add("sw $t9, 0($sp)");
    	instructions.add("move $t9, $sp");
    	instructions.add("addiu $sp, $sp, -4");
    	instructions.add("# end of begin block");
    }

    public void endBlock(){
    	instructions.add("# start of end block");	
    	instructions.add("move $sp, $t9");
    	instructions.add("lw $t9, 0($sp)");
    	instructions.add("# end of end block");	
    }

    public void putForLabel(int cnt){
    	instructions.add("# start of putting for Label");
    	instructions.add("LOOP_" + cnt + ":");
    	instructions.add("# end of putting for Label");
    }

    public void assigningID(Type type, int cnt){
    	instructions.add("# start of assigning ID");
    	instructions.add("li $a0, " + type.size());
    	instructions.add("lw $t2, 12($sp)"); // loading ID_iter
    	instructions.add("mul $t0 , $t2, $a0"); // ID_iter * size
    	instructions.add("addiu $t0 , $t0, 20"); // ID_iter * size + 20
    	instructions.add("add $t0, $t0, $sp"); // ID_iter * size + 20 + $sp
    	instructions.add("lw $a0,4($sp)"); // addr of ID

    	for(int i=0; i<type.size()/4; i++){
    		instructions.add("lw $t1," +   String.format("%d", 4*i) + "($t0)");
    		instructions.add("sw $t1," +  String.format("%d", 4*i) + "($a0)");
    	}
    	instructions.add("lw $t3, 16($sp)"); // loading size
    	instructions.add("beq $t3, $t2, END_LOOP_" + cnt);
    	instructions.add("addiu $t2, $t2, 1");
    	instructions.add("sw $t2, 12($sp)");
    	instructions.add("# end of assigning ID");
    }

    public void EndForLabel(int cnt) {

    	instructions.add("# start of putting Label for END LOOP ");
    	instructions.add("move $sp, $t9"); /////////////////
    	instructions.add("addiu $sp,$sp ,-4");
    	instructions.add("j LOOP_" + cnt);
    	instructions.add("END_LOOP_" + cnt + ":");
    	instructions.add("# end of putting Label for END LOOP ");
    }

    public void jumpEndForLabel(int cnt){
    	instructions.add("# start of jumping to End of For");
    	instructions.add("j END_LOOP_" + cnt);
    	instructions.add("# start of jumping to End of For");
    }

    public void startRecv(int RecvCnt){
    	instructions.add("# start of adding Label for start of Recv");
    	instructions.add("RECV_" + RecvCnt + ":");
    	instructions.add("# end of adding Label for start of Recv");
    }

    public void endRecv(int cnt){
    	instructions.add("# start of adding Label for end of Recv");
    	instructions.add("END_RECV_" + cnt + ":");
    	instructions.add("j SCHEDULER");
    	instructions.add("# end of adding Label for end of Recv");
    }

    public void jumpEndRecv(int cnt){
    	instructions.add("# start of jumping to Label for end of Recv");
		instructions.add("j END_RECV_" + cnt);
    	instructions.add("# end of jumping to Label for end of Recv");
    }

    public void addLocalVariable(int adr, Type type){ /// stm_vardef handle shavad
    	if(type instanceof CharType){
			instructions.add("# adding a CharType variable");
			instructions.add("li $a0, 0" );
			instructions.add("sw $a0, " + adr + "($fp)");
			instructions.add("# end of adding a CharType variable");
        }

        if(type instanceof IntType){
          	instructions.add("# adding a IntType variable");
          	instructions.add("li $a0, -1");
          	instructions.add("sw $a0, " + adr + "($fp)");
          	instructions.add("# end of adding a IntType variable");
        }
        if(type instanceof ArrType){
          	ArrType arrType = (ArrType) type;
          	int mult = 1;
          	int x = 0, step= 4;

          	for(int i=0; i<arrType.dimension.size(); i++)
            	mult *= Integer.parseInt( arrType.dimension.get(i).toString() );

          	if(arrType.base instanceof IntType) {
	          	instructions.add("# adding a Int ArrType variable");
	          	for(int i=0; i<mult; i++){
	           	 	instructions.add("li $a0, -1");
	            	instructions.add("sw $a0, " + String.format("%d",adr + step*i) + "($fp)");
	          	}
	          	instructions.add("# end of adding a Int ArrType variable");
          	}
          	else if(arrType.base instanceof CharType){
          		instructions.add("# adding a Char ArrType variable");          	
				for(int i=0; i<mult; i++){
	           	 	instructions.add("li $a0, 0");
	            	instructions.add("sw $a0, " + String.format("%d",adr + step*i) + "($fp)");
	          	}

	          	instructions.add("# end of adding a Char ArrType variable");
          	}
        }
    }	// stacko won't change

    public void addVariableToStack(Type type){//var is already defined
    	//addr e mored e nazar sar e stack bude
        if(type instanceof CharType){
	        instructions.add("# start of adding char variable to stack");
	        instructions.add("lw $a0, 4($sp)"); 
	        instructions.add("lw $a0, 0($a0)"); 
	        instructions.add("sw $a0, 4($sp)");
	        instructions.add("# end of adding char variable to stack");
        }
        if(type instanceof IntType){
          	instructions.add("# start of adding Int variable to stack");
          	instructions.add("lw $a0, 4($sp)");
          	instructions.add("lw $a0, 0($a0)"); 
	        instructions.add("sw $a0, 4($sp)");
          	instructions.add("# end of adding Int variable to stack");
        }
        if(type instanceof ArrType){
	        ArrType arrType = (ArrType) type;
          	int mult = 1;

	        for(int i=0; i<arrType.dimension.size();i++){
	        	mult *= Integer.parseInt( arrType.dimension.get(i).toString() );
	        }

	        instructions.add("# start of adding ArrType variable to stack");
	        instructions.add("lw $t0, 4($sp)");
	        for(int i = mult-1 ; i >= 0; i--){
	        	instructions.add("lw $a0, " + String.format("%d",4*i) + "($t0)");
	        	instructions.add("sw $a0, 4($sp)");
	        	instructions.add("addiu $sp, $sp, -4");
	        }
	        instructions.add("addiu $sp, $sp, 4");
	        instructions.add("# end of adding ArrType variable to stack");
        }
    }	// one above the stack top

    public void addArrayAddrToStack(int cnt, ArrType arrType){
    	instructions.add("#start of loading array addr to stack");

    	int mult = 4;
    	 
    	for(int i=cnt; i<arrType.dimension.size(); i++){
    		mult *= Integer.parseInt(arrType.dimension.get(i).toString()) ;
    	}
    	instructions.add("li $t1, 0");
    	for(int i=cnt-1 ; i>=0; i--){
    		instructions.add("lw $a0, 4($sp)");

    		instructions.add("li $t2, " + String.format("%d", Integer.parseInt(arrType.dimension.get(i).toString()))); //IndexOutOfRange
    		instructions.add("bge $a0, $t2, IndexOutOfRange");

    		instructions.add("li $t0, "+String.format("%d", mult));
    		instructions.add("mul $t0, $a0, $t0");
    		instructions.add("addu $t1, $t1, $t0");
    		instructions.add("addiu $sp, $sp, 4");
    		mult *= Integer.parseInt(arrType.dimension.get(i).toString());
    	}
    	instructions.add("lw $a0, 4($sp)");
    	instructions.add("addu $t1, $t1, $a0");
    	instructions.add("sw $t1, 4($sp)");
    } // one above stack top

    public void addLocalVariableAddrToStack(int adr){
        instructions.add("# start of adding local var address to stack");
        instructions.add("addiu $a0, $fp, " + adr);
        instructions.add("sw $a0, 0($sp)");
        instructions.add("addiu $sp, $sp, -4");
        instructions.add("# end of adding local var address to stack");
    }	// one above the stack

    public void addGlobalVariable(int adr, Type type){
    	GlobalSum += type.size();

        if(type instanceof CharType){
			initInstructions.add("# adding a CharType global variable");
			initInstructions.add("li $a0, 0" );
			initInstructions.add("sw $a0, " + adr + "($gp)");
			initInstructions.add("# end of adding a CharType global variable");

        }

        if(type instanceof IntType){
          	initInstructions.add("# adding a IntType global variable");
          	initInstructions.add("li $a0, -1");
          	initInstructions.add("sw $a0, " + adr + "($gp)");
          	initInstructions.add("# end of adding a IntType global variable");
          	
        }
        if(type instanceof ArrType){
          	ArrType arrType = (ArrType) type;
          	int mult = 1;
          	int x = 0, step= 4;

          	for(int i=0; i<arrType.dimension.size(); i++)
            	mult *= Integer.parseInt( arrType.dimension.get(i).toString() );

          	if(arrType.base instanceof IntType) {
	          	initInstructions.add("# adding a Int ArrType global variable");
	          	for(int i=0; i<mult; i++){
	           	 	initInstructions.add("li $a0, -1");
	            	initInstructions.add("sw $a0, " + String.format("%d",adr + step*i) + "($gp)");
	          	}
	          	initInstructions.add("# end of adding a Int ArrType global variable");
          	}
          	else if(arrType.base instanceof CharType){
				initInstructions.add("# adding a Char ArrType global variable");	          	
				for(int i=0; i<mult; i++){
	           	 	initInstructions.add("li $a0, 0");
	            	initInstructions.add("sw $a0, " + String.format("%d",adr + step*i) + "($gp)");
	          	}

	        	initInstructions.add("# end of adding a Char ArrType global variable");
          	}

        }
    }	// stack won't change


    public void addGlobalVariableAddrToStack(int adr){
        instructions.add("# start of adding global var address to stack");
        instructions.add("addiu $a0, $gp, " + adr);
        instructions.add("sw $a0, 0($sp)");
        instructions.add("addiu $sp, $sp, -4");
        instructions.add("# end of adding global var address to stack");
    }	// one above the stack top

    public void addConstIntToStack(int x){
        instructions.add("# adding a number to stack");
        instructions.add("li $a0, " + x);
        instructions.add("sw $a0, 0($sp)");
        instructions.add("addiu $sp, $sp, -4");
        instructions.add("# end of adding a number to stack");
    }	// one above the stack top

    public void addConstCharToStack(int c){
        instructions.add("# adding a char to stack");
        instructions.add("li $a0, " + c);
        instructions.add("sw $a0, 0($sp)");
        instructions.add("addiu $sp, $sp, -4");
        instructions.add("# end of adding a char to stack");

    }	// one above the stack top

    public void addConstStrToStack(String str){
    
        instructions.add("# adding a string to stack");

        for(int i=str.length()-2; i>0; i--){
        	int c = str.charAt(i);
	    	instructions.add("li $a0, " + c);
        	instructions.add("sw $a0, 0($sp)");
        	instructions.add("addiu $sp, $sp, -4");
        }

       	instructions.add("# end of adding a string to stack");

    }	// one above the stack top

    

}
