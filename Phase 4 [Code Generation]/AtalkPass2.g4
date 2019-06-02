grammar AtalkPass2;
@header {
	import java.util.*;
}

@members{
	int IsInit = 0;
	int IsElementArrNotProper = 0;
	int forStack = 0;
	int ifCnt = 0;
	int forCnt = 0;
	int RecvCnt = 0;
	int ActorCnt = 0;
	int MaxMesgSize = 0;
	ArrayList<Integer> ActorSize = new ArrayList<Integer>();
	ArrayList<Integer> initInd = new ArrayList<Integer>();
	String CurrActor ="";
	Stack<Integer> forCntStack = new Stack<Integer>();
	HashMap<String, Integer> Act2Ind = new HashMap<String, Integer>();
	HashMap<String, Integer> Recv2Ind = new HashMap<String, Integer>();

	void print(String str){
        System.out.println(str);
    }

    void beginScope() {
        SymbolTable.push();
    }

    void endScope() {
        print("Stack offset: " + SymbolTable.top.getOffset(Register.SP) + ", Global offset: " + SymbolTable.top.getOffset(Register.GP));
        SymbolTable.pop();
    }

    void putNoTypeVar(String name){
        try{
	        SymbolTable.top.put(
	            new SymbolTableLocalVariableItem(
	                new Variable(name, NoType.getInstance()),
	                SymbolTable.top.getOffset(Register.SP)
	            )
	        );
   		}
   		catch(ItemAlreadyExistsException e){}
    }

		AtalkTranslator mips = new AtalkTranslator();
}

program:
	{
        print("Pass2 started -------------------------");
        beginScope();
        int rcvCnt = 0;
        ArrayList Actors = new ArrayList(SymbolTable.top.items.values()) ;
        for(int i=Actors.size() - 1; i >= 0; i--){
        	ActorType tmp = (ActorType) Actors.get(i);
        	ActorSize.add(tmp.BufSize);
        	if(MaxMesgSize < tmp.MaxMesg)
        		MaxMesgSize = tmp.MaxMesg;
        	Act2Ind.put(tmp.getKey(), Actors.size() - i - 1);
        	boolean This_flag = false;
        	for(int j=0; j< tmp.Recv.size(); j++){
        		rcvCnt++;
        		
				Recv2Ind.put(tmp.getKey()+"_"+tmp.Recv.get(j), rcvCnt);
				if(tmp.Recv.get(j).equals("init()") == true){
					initInd.add(rcvCnt);
					This_flag = true;
				}
				
			}
			if(This_flag == false)
				initInd.add(0);

        }
        mips.setMaxMesg(MaxMesgSize + 4);
    }
		(actor | NL)*
	{

        endScope();
        print("Pass2 finished -------------------------");
				mips.makeOutput(ActorSize, initInd, MaxMesgSize+4,RecvCnt);
    }
	;

actor:
		'actor' actor_name = ID '<' num = CONST_NUM '>' NL
		{
			beginScope();
			
			CurrActor = $actor_name.text ;
			
			
		}
			(state | receiver | NL)*

		'end' (NL | EOF)
		{endScope(); ActorCnt++;}
	;

state:
		var_type = type var_id = ID
			{
				SymbolTableItem item = SymbolTable.top.get($var_id.text);
				SymbolTableVariableItemBase var = (SymbolTableVariableItemBase) item;
				mips.addGlobalVariable(var.getOffset(), var.getVariable().getType());
			}
		(',' var_id = ID
			{
				item = SymbolTable.top.get($var_id.text);
				var = (SymbolTableVariableItemBase) item;
				mips.addGlobalVariable(var.getOffset(), var.getVariable().getType());
			}
		)* NL
	;

receiver:

		{ 
			beginScope();
			int cnt = 0; RecvCnt++;
        		
			int RecvMesgSize = 0;
			int argSize = 0;
			mips.startRecv(RecvCnt);
		}
		'receiver' temp = ID '(' (type id = ID

		{

			cnt++; 
			SymbolTable.define(); 
			SymbolTableLocalVariableItem var = (SymbolTableLocalVariableItem)SymbolTable.top.get($id.text);

			mips.addLocalVariable(var.getOffset(), var.getVariable().getType());

			mips.addLocalVariableAddrToStack(var.getOffset());
			mips.loadFromQ(ActorSize, Act2Ind.get(CurrActor), argSize, var.getVariable().getType());
			mips.assignCommand(var.getVariable().getType());
			argSize += var.getVariable().getType().size();
		} 

		(',' type id = ID 

		{ 
			cnt++; 
			SymbolTable.define(); 
			SymbolTableLocalVariableItem item = (SymbolTableLocalVariableItem)SymbolTable.top.get($id.text);

			mips.addLocalVariable(item.getOffset(), item.getVariable().getType());

			mips.addLocalVariableAddrToStack(item.getOffset());
			mips.loadFromQ(ActorSize, Act2Ind.get(CurrActor), argSize, item.getVariable().getType());
			mips.assignCommand(item.getVariable().getType());
			argSize += item.getVariable().getType().size();

		})*)? ')' NL

			{				
				if(MaxMesgSize < RecvMesgSize)
					MaxMesgSize = RecvMesgSize;
				
				mips.loadFromQ(ActorSize, Act2Ind.get(CurrActor));
				
				if(($temp.text.equals("init") == true) && (cnt == 0))
					IsInit = 1;
			}
			statements
		'end' NL
		{
			mips.endRecv(RecvCnt);
			IsInit = 0;
			endScope();
		}

	;

type:
		'char' ('[' CONST_NUM ']')*
	|	'int' ('[' CONST_NUM ']')*
	;

block:	{
			beginScope();
			SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
			mips.beginBlock();

		}

		'begin' NL
			statements
		'end' NL

		{
			mips.endBlock();
			endScope();
		}
	;

statements:
		(statement | NL)*
	;

statement:
		stm_vardef			//*
	|	stm_assignment		//*
	|	stm_foreach          //*
	|	stm_if_elseif_else	//*
	|	stm_quit
	|	stm_break		//*
	|	stm_tell
	|	stm_write		//*
	|	block			//*
	;

stm_vardef:
		type id=ID 
		{
		 	SymbolTable.define(); 
		 	SymbolTableLocalVariableItem var = (SymbolTableLocalVariableItem)SymbolTable.top.get($id.text);
		 	mips.addLocalVariable(var.getOffset(), var.getVariable().getType());

		}

	    ('=' { mips.addLocalVariableAddrToStack(var.getOffset()); }temp=expr
			{
				mips.assignCommand($temp.return_type);
				SymbolTableLocalVariableItem item = (SymbolTableLocalVariableItem)SymbolTable.top.get($id.text);

				if($temp.return_type.toString().equals(item.getVariable().getType().toString()) == false ){
					print(String.format("[Line #%s] assignment unavailable", $temp.line));
				}
			}
		)?
		(',' id1 = ID 
		{ 
			SymbolTable.define(); 
			SymbolTableLocalVariableItem var1 = (SymbolTableLocalVariableItem)SymbolTable.top.get($id1.text);
		 	mips.addLocalVariable(var1.getOffset(), var1.getVariable().getType());
		} 
		('=' { mips.addLocalVariableAddrToStack(var1.getOffset()); }tmp=expr
			{
				mips.assignCommand($tmp.return_type);
				SymbolTableLocalVariableItem item = (SymbolTableLocalVariableItem)SymbolTable.top.get($id1.text);

				if($tmp.return_type.toString().equals(item.getVariable().getType().toString()) == false ){
					print(String.format("[Line #%s] assignment unavailable", $temp.line));
				}
			}

		)?)* NL

	;

stm_tell:
		{String TELL;}
		(

		id = ID
		{
			TELL = $id.text;

			
			//System.err.println("Hello");
            if(Act2Ind.containsKey(TELL) == false)
                print(String.format("[Line #%s] actor \"%s\" doesn't exist.", $id.getLine(), $id.text));
		}
		| id = 'sender'
			{
				TELL = "sender";
				if(IsInit == 1)
					print(String.format("[Line #%s] \"init\" receiver has no access to sender actor.", $id.getLine()));
					/* EMTIAZI */
			}
		| 'self'
			{
				TELL = "self";
			}
		)
		{
			ArrayList arg = new ArrayList();
		}
		'<<' temp = ID '(' (Tmp=expr 
		{
			if($Tmp.IsLvalue == 1)
				mips.addVariableToStack($Tmp.return_type);
			arg.add($Tmp.return_type);
		}
		(',' tmp=expr 
		{
			if($tmp.IsLvalue == 1)
				mips.addVariableToStack($tmp.return_type);
			arg.add($tmp.return_type);

		})*)? ')' NL

		{
			String sign = new ReceiveType($temp.text, arg).getKey();

			if(TELL.equals("self") == true){
				SymbolTableItem item = SymbolTable.top.get(sign);
				if(item == null)
                	print(String.format("[Line #%s] this actor has not receiver \"%s\".", $temp.getLine(), sign));
                else{
                	mips.add2Q(ActorSize,Act2Ind.get(CurrActor), Recv2Ind.get(CurrActor + "_" + sign), arg);
                }
			}
			else if(TELL.equals("sender") == true){/*EMTIAZI*/

			}
			else{
				
				if(Act2Ind.containsKey(TELL) == true){
					int haveRecv = 0;
					SymbolTableItem item = SymbolTable.top.get(TELL);
					ActorType casted = (ActorType)item;
					for(int i=0; i<casted.Recv.size(); i++){
						if(casted.Recv.get(i).equals(sign) == true){
							haveRecv = 1;
							
							mips.add2Q(ActorSize,Act2Ind.get(TELL), Recv2Ind.get(TELL + "_" + sign), arg);
						}
					}
					if(haveRecv == 0)
						print(String.format("[Line #%s] actor \"%s\" doesn't have receiver \"%s\".", $temp.getLine(), TELL, sign));

				}
			}
		}
	;

stm_write:
		'write' '('
		temp=expr
		{
			if(($temp.return_type.toString().equals("int") == true) || $temp.return_type.toString().equals("char")==true ||
			 (($temp.return_type instanceof ArrType) && (((ArrType)$temp.return_type).base.toString().equals("char") == true) && (((ArrType)$temp.return_type).dimension.size()== 1))){
			 	if($temp.IsLvalue ==1)
			 		mips.addVariableToStack($temp.return_type);
				mips.write($temp.return_type);
			}
			else{
				print(String.format("[Line #%s] \"write\" operation in not valid.", $temp.line));
			}
		}
		')' NL
	;

stm_if_elseif_else:
		{
			int thisIfInd = 0;
			beginScope();
			int elseIfCnt = 0;
			SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);

		}
		'if' temp = expr
		{
			ifCnt++;
			thisIfInd = ifCnt;
			if($temp.return_type.toString().equals("int") == false){
				print(String.format("[Line #%s] if condition is invalid.", $temp.line));
			}
			mips.ifChecking(thisIfInd);
		}
		NL statements
		{
			endScope();
			mips.ifEnd(thisIfInd);
		}
		(
			{
				beginScope();
				SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
			}
			'elseif' { mips.putNotIf_NotElseIf(thisIfInd, elseIfCnt); } tmp = expr
			{				

				elseIfCnt++;
				if($tmp.return_type.toString().equals("int") == false){
					print(String.format("[Line #%s] if condition is invalid.", $tmp.line));
				}
				mips.elseifChecking(thisIfInd, elseIfCnt);
			}
			 NL statements
			{
				endScope();
				mips.ifEnd(thisIfInd);
			}
		)*
		{ mips.putNotIf_NotElseIf(thisIfInd, elseIfCnt); } 
		(
			{
				beginScope();
				SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
			}
			'else' NL statements
			{endScope();}
		)?
		{ mips.putEndIf(thisIfInd); }
		'end' NL

	;

stm_foreach:
		{
			int thisForInd = forCnt++;
			forCntStack.push(thisForInd);
			beginScope();
			int thisForVar = 0;
		}
		'foreach' temp = ID 'in' tmp=expr NL

		{
			if($tmp.return_type instanceof ArrType){
				ArrType G = (ArrType)$tmp.return_type;
				forStack += G.base.size();
				if(G.dimension.size() == 1){
				        SymbolTable.top.replace($temp.text ,
				            new SymbolTableLocalVariableItem(
				                new Variable($temp.text, G.base),
				                SymbolTable.top.getOffset(Register.SP) + forStack
				            )
				        );
				        SymbolTable.define();
				        SymbolTableVariableItemBase castedItem = (SymbolTableVariableItemBase)SymbolTable.top.get($temp.text);
				        thisForVar = G.base.size();
				        SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
				}
				else{
					ArrayList arg = new ArrayList(G.dimension.subList(1, G.dimension.size()));
				    SymbolTableVariableItemBase castedItem = (SymbolTableVariableItemBase)SymbolTable.top.get($temp.text);
				    thisForVar = G.size() / Integer.parseInt(G.dimension.get(0).toString());
				    forStack += G.size() / Integer.parseInt(G.dimension.get(0).toString());
			        SymbolTable.top.replace($temp.text,
			            new SymbolTableLocalVariableItem(
			                new Variable($temp.text, ArrType.getInstance(G.base, arg)),
			                SymbolTable.top.getOffset(Register.SP) + forStack
			            )
			        );
			        SymbolTable.define();
				    SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
				}
				if($tmp.IsLvalue == 1)
					mips.addVariableToStack($tmp.return_type); //const for tmp

				mips.addConstIntToStack(Integer.parseInt (G.dimension.get(0).toString())); // add size to stack
				mips.addConstIntToStack(0); // add counter to stack

			}
			else{
				print(String.format("[Line #%s] can not iterate in non array variable.", $tmp.line));
			}
		}
			{ 
				mips.beginBlock();
				mips.putForLabel(thisForInd);
				
				SymbolTableLocalVariableItem var = (SymbolTableLocalVariableItem)SymbolTable.top.get($temp.text);
				mips.addLocalVariable(SymbolTable.top.getOffset(Register.SP), var.getVariable().getType());
				mips.addLocalVariableAddrToStack(SymbolTable.top.getOffset(Register.SP));
				mips.assigningID(var.getVariable().getType(), thisForInd);
			}

			statements

		'end' NL
		{
			mips.EndForLabel(thisForInd);
			mips.endBlock();
			endScope();
			forStack -= thisForVar;
			forCntStack.pop();
		}
	;

stm_quit:
		'quit' NL
		{
			mips.jumpEndRecv(RecvCnt);
		}
	;

stm_break:
		'break' NL
		{
			mips.jumpEndForLabel(forCntStack.Top());
		}
	;

stm_assignment:
		expr NL
	;

expr returns [Type return_type, int line, int IsLvalue]:
		temp = expr_assign
		{
			$return_type = $temp.return_type;
			$line = $temp.line;
			$IsLvalue = $temp.IsLvalue;
		}
	;

expr_assign returns [Type return_type, int line, int IsLvalue]: //  IsLvalue shows whether address or data
		temp = expr_or '=' tmp = expr_assign
		{
			if($temp.return_type.toString().equals($tmp.return_type.toString()) == false ){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] assignment unavailable", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;

			}
			if($temp.IsLvalue == 0)
				print(String.format("[Line #%s] Lvalue is not correct", $temp.line));
			else{
				$IsLvalue = 1;
				if($tmp.IsLvalue == 1){
					mips.addVariableToStack($tmp.return_type);
				}
				mips.assignCommand($tmp.return_type);
			}
		}
	|	temp = expr_or
		{
			$return_type = $temp.return_type;
			$line = $temp.line;
			$IsLvalue = $temp.IsLvalue;
		}
	;

expr_or returns [Type return_type, int line, int IsLvalue]:
		temp = expr_and tmp = expr_or_tmp
		{
			if($tmp.return_type != null && ($temp.return_type.toString().equals($tmp.return_type.toString()) == false) )
				$return_type = NoType.getInstance();

			if($tmp.return_type != null && ($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false)){
				$return_type = NoType.getInstance();
				print(String.format("[Line #%s] \"or\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
			}
			$line = $temp.line;
			if($tmp.return_type != null){
				$IsLvalue = 0;
				if($temp.IsLvalue == 1){ // addr bud
					mips.addrOrCommand();
				}
				if($temp.IsLvalue == 0){ // const bud
					mips.constOrCommand();
				}
			}
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_or_tmp returns [Type return_type, int line]:
		'or' temp=expr_and tmp = expr_or_tmp
		{
			if( ($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] \"or\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
				if($tmp.return_type == null && $temp.IsLvalue == 1){
					mips.addVariableToStack($temp.return_type);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 1){ // addr bud
					mips.addrOrCommand();
				}
				if($tmp.return_type != null && $temp.IsLvalue == 0){ // const bud
					mips.constOrCommand();
				}
			}
		}
	|
	;

expr_and returns [Type return_type, int line, int IsLvalue]:
		temp = expr_eq tmp = expr_and_tmp
		{
			if($tmp.return_type != null && ($temp.return_type.toString().equals($tmp.return_type.toString()) == false) )
				$return_type = NoType.getInstance();

			if($tmp.return_type != null && ($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				print(String.format("[Line #%s] \"and\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
			}
			$line = $temp.line;
			if($tmp.return_type != null){

				$IsLvalue = 0;
				if($temp.IsLvalue == 1){ // addr bud
					mips.addrAndCommand();
				}
				if($temp.IsLvalue == 0){ // const bud
					mips.constAndCommand();
				}
			}
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_and_tmp returns [Type return_type, int line]:
		'and' temp=expr_eq tmp=expr_and_tmp
		{
			if( ($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] \"and\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
				if($tmp.return_type == null && $temp.IsLvalue == 1){
					mips.addVariableToStack($temp.return_type);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 1){ // addr bud
					mips.addrAndCommand();
				}
				if($tmp.return_type != null && $temp.IsLvalue == 0){ // const bud
					mips.constAndCommand();
				}
			}
		}
	|
	;

expr_eq returns [Type return_type, int line, int IsLvalue]:
	temp = expr_cmp tmp = expr_eq_tmp
		{
			if($tmp.return_type != null && ($temp.return_type.toString().equals($tmp.return_type.toString()) == false) ){
				$return_type = NoType.getInstance();
				print(String.format("[Line #%s] \"==\" or \"<>\" can't be used.", $temp.line));
			}
			else if($tmp.return_type == null){
				$return_type = $temp.return_type;
			}
			else{	// baraye moqayese ebarat e bi mani mitavan an ra 0 va 1 dar nazar gereft
				$return_type = IntType.getInstance();
			}
 			$line = $temp.line;
 			if($tmp.return_type != null){
				$IsLvalue = 0;
				if($temp.IsLvalue == 1){ // addr bud
					mips.addrEqCommand($tmp.opr, $temp.return_type);
				}
				if($temp.IsLvalue == 0){ // const bud
					mips.constEqCommand($tmp.opr, $temp.return_type);
				}
 			}
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_eq_tmp returns [Type return_type, int line, String opr]:
		op=('==' | '<>') temp = expr_cmp tmp = expr_eq_tmp
		{
			$opr = $op.text;
			if($tmp.return_type != null){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] multiple comparison can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
				if($tmp.return_type == null && $temp.IsLvalue == 1){
					mips.addVariableToStack($temp.return_type);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 1){ // addr bud
					mips.addrEqCommand($op.text, $temp.return_type);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 0){ // const bud
					mips.constEqCommand($op.text, $temp.return_type);
				}
			}
		}
	|
	;

expr_cmp returns [Type return_type, int line, int IsLvalue]:
		temp = expr_add tmp = expr_cmp_tmp
		{
			if($tmp.return_type != null && ($temp.return_type.toString().equals($tmp.return_type.toString()) == false) ){
				$return_type = NoType.getInstance();
				print(String.format("[Line #%s] \"<\" or \">\" can't be used.", $temp.line));
			}
			else if($tmp.return_type == null){
				$return_type = $temp.return_type;
			}
			else{	// baraye moqayese ebarat e bi mani mitavan an ra 0 va 1 dar nazar gereft
				$return_type = IntType.getInstance();
			}
 			$line = $temp.line;
 			if($tmp.return_type != null){
				$IsLvalue = 0;
				if($temp.IsLvalue == 1){ // addr bud
					mips.addrCmpCommand($tmp.opr);
				}
				if($temp.IsLvalue == 0){ // const bud
					mips.constCmpCommand($tmp.opr);
				}
 			}
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_cmp_tmp returns [Type return_type, int line, String opr]:
		op=('<' | '>') temp = expr_add tmp = expr_cmp_tmp
		{
			$opr = $op.text;
			if($tmp.return_type != null){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] multiple comparison can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
				if($tmp.return_type == null && $temp.IsLvalue == 1){
					mips.addVariableToStack($temp.return_type);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 1){ // addr bud
					mips.addrCmpCommand($op.text);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 0){ // const bud
					mips.constCmpCommand($op.text);
				}
			}
		}
	|
	;

expr_add returns [Type return_type, int line, int IsLvalue]:
		temp = expr_mult tmp = expr_add_tmp
		{
			if($tmp.return_type != null && ($temp.return_type.toString().equals($tmp.return_type.toString()) == false) )
				$return_type = NoType.getInstance();

			if($tmp.return_type != null && ($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				print(String.format("[Line #%s] \"+\" or \"-\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
			}
			$line = $temp.line;
			if($tmp.return_type != null){
				$IsLvalue = 0;
				if($temp.IsLvalue == 1){ // addr bud
					mips.addrAddCommand($tmp.opr);
				}
				if($temp.IsLvalue == 0){ // const bud
					mips.constAddCommand($tmp.opr);
				}
			}
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_add_tmp returns [Type return_type, int line, String opr]:
		op=('+' | '-') temp=expr_mult tmp = expr_add_tmp
		{
			$opr = $op.text;
			if(($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] \"+\" or \"-\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
				if($tmp.return_type == null && $temp.IsLvalue == 1){
					mips.addVariableToStack($temp.return_type);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 1){ // addr bud
					mips.addrAddCommand($op.text);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 0){ // const bud
					mips.constAddCommand($op.text);
				}
			}
		}
	|
	;

expr_mult returns [Type return_type, int line, int IsLvalue]:
		temp = expr_un tmp = expr_mult_tmp
		{
			if($tmp.return_type != null && ($temp.return_type.toString().equals($tmp.return_type.toString()) == false) )
				$return_type = NoType.getInstance();
			if($tmp.return_type != null && ($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				print(String.format("[Line #%s] \"*\" or \"/\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
			}
			$line = $temp.line;
			if($tmp.return_type != null){
				$IsLvalue = 0;
				if($temp.IsLvalue == 1){ // addr bud
					mips.addrMultCommand($tmp.opr);
				}
				if($temp.IsLvalue == 0){ // const bud
					mips.constMultCommand($tmp.opr);
				}
			}
			else
				$IsLvalue = $temp.IsLvalue;

		}
	;

expr_mult_tmp returns [Type return_type, int line, String opr]:
		op=('*' | '/') temp = expr_un tmp = expr_mult_tmp
		{
			$opr = $op.text; 
			if(($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] \"*\" or \"/\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
				if($tmp.return_type == null && $temp.IsLvalue == 1){
					mips.addVariableToStack($temp.return_type);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 1){ // addr bud
					mips.addrMultCommand($op.text);
				}
				if($tmp.return_type != null && $temp.IsLvalue == 0){ // const bud
					mips.constMultCommand($op.text);
				}
			}

		}
	|
	;

expr_un returns [Type return_type, int line, int IsLvalue]:
		op=('not' | '-') tmp = expr_un
		{
			if(($tmp.return_type.toString().equals("int") == false) && ($tmp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				$line = $tmp.line;
				print(String.format("[Line #%s] \"not\" or \"-\" can't be used.", $tmp.line));
			}
			else{
				$return_type = $tmp.return_type;
				$line = $tmp.line;
			}
			$IsLvalue = 0;	
			if($tmp.IsLvalue == 1){
				mips.addVariableToStack($tmp.return_type);
			}
			mips.notVarCommand($op.text);
			
		}
	|	temp = expr_mem
		{
		$return_type = $temp.return_type;
		$line = $temp.line;
		$IsLvalue = $temp.IsLvalue;
		}
	;

expr_mem returns [Type return_type, int line, int IsLvalue]:
		temp = expr_other mem_cnt = expr_mem_tmp
		{

			if($mem_cnt.cnt == 0){
				$return_type = $temp.return_type;

			}
			else if( $temp.return_type instanceof ArrType ){
				ArrType tmp = (ArrType)$temp.return_type;
				if($mem_cnt.cnt < tmp.dimension.size()){
					$return_type = ArrType.getInstance(tmp.base, new ArrayList(tmp.dimension.subList($mem_cnt.cnt, tmp.dimension.size())));
					mips.addArrayAddrToStack($mem_cnt.cnt, tmp);
				}

				if($mem_cnt.cnt == tmp.dimension.size()){
					$return_type = tmp.base;
					mips.addArrayAddrToStack($mem_cnt.cnt, tmp);
				}

				if($mem_cnt.cnt > tmp.dimension.size()){
					$return_type = NoType.getInstance();
					print(String.format("[Line #%s] dimensions of array variable doesn't match.", $temp.line));
				}
			}
			else if($temp.IsLvalue == 1){
				$return_type = NoType.getInstance();
				print(String.format("[Line #%s] variable isn't array.", $temp.line));
			}
			else{
				$return_type = NoType.getInstance();
				print(String.format("[Line #%s] Lvalue is not correct.", $temp.line));
			}

			$line = $temp.line;
			$IsLvalue = $temp.IsLvalue;
		}
	;

expr_mem_tmp returns [int cnt]:
		'['  temp = expr ']' tmp = expr_mem_tmp
		{
			if($temp.IsLvalue == 1) 
				mips.addVariableToStack($temp.return_type);
			$cnt = $tmp.cnt + 1;
			if($temp.return_type.toString().equals("int") == false){
				print(String.format("[Line #%s] invalid array index.", $temp.line));
			}
		}
	| { $cnt = 0; }
	;

expr_other returns [Type return_type, int line, int IsLvalue]:

		temp = CONST_NUM
		{
			$return_type = IntType.getInstance();
			$line = $temp.getLine();
			$IsLvalue = 0;
			mips.addConstIntToStack( Integer.parseInt($temp.text));
		}

	|	temp = CONST_CHAR {
			$return_type = CharType.getInstance();
			$line = $temp.getLine();
			$IsLvalue = 0;
			mips.addConstCharToStack( (int)$temp.text.charAt(1) );
		}

	|	temp = CONST_STR
		{
			ArrayList arg = new ArrayList();
			arg.add($temp.text.length() - 2);
			$return_type = ArrType.getInstance(CharType.getInstance(), arg);
			$line = $temp.getLine();
			$IsLvalue = 0;
			mips.addConstStrToStack( $temp.text );
		}

	|	id = ID
		{

			SymbolTableItem item = SymbolTable.top.get($id.text);
            if(item == null) {
                print(String.format("[Line #%s] variable \"%s\" is not defined.", $id.getLine(), $id.text));
                putNoTypeVar($id.text);
                $return_type = NoType.getInstance();
                $line = $id.getLine();
            }
            else if(item instanceof SymbolTableVariableItemBase) {
            	SymbolTableVariableItemBase castedItem = (SymbolTableVariableItemBase) item;
            	$line = $id.getLine();
            	$return_type = castedItem.getVariable().getType();
            	if(castedItem.getBaseRegister() == Register.GP)//	Variable is global
            		mips.addGlobalVariableAddrToStack(castedItem.getOffset());
            	else if(castedItem.getBaseRegister() == Register.SP){
            		mips.addLocalVariableAddrToStack(castedItem.getOffset());
            	}
            }
           	else{
           		print(String.format("[Line #%s] variable \"%s\" is not defined.", $id.getLine(), $id.text));
                putNoTypeVar($id.text);
                $line = $id.getLine();
   				$return_type = NoType.getInstance();
           	}
           	$IsLvalue = 1;

		}

	|	'{' {
				IsElementArrNotProper = 0;

				int ElementCounter = 1;
			}
			Temp= expr 
			{
				if($Temp.IsLvalue == 1) 
					mips.addVariableToStack($Temp.return_type);

		    }
		    (',' tmp = expr
			{
				if($Temp.IsLvalue == 1) 
					mips.addVariableToStack($Temp.return_type);
				ElementCounter += 1;
				if($Temp.return_type.toString().equals($tmp.return_type.toString()) == false) {
					$return_type = NoType.getInstance();
					$line = $Temp.line;
					IsElementArrNotProper = 1;
					print(String.format("[Line #%s] elements are not from the same type.", $Temp.line));
				}
			}
			)* 
		'}'


	{

		mips.arrange($Temp.return_type, ElementCounter);

		if(IsElementArrNotProper == 0){
			if($Temp.return_type instanceof ArrType){
				ArrayList arg = new ArrayList();
				arg.add(ElementCounter);
				ArrType G = (ArrType)$Temp.return_type;
				arg.addAll(G.dimension);
				$return_type = ArrType.getInstance(G.base, arg);
				$line = $Temp.line;
			}
			else{
				ArrayList arg = new ArrayList();
				arg.add(ElementCounter);
				$return_type = ArrType.getInstance($Temp.return_type, arg);
				$line = $Temp.line;
			}
		}
		$IsLvalue = 0;
	}


	|	'read' '(' temp = CONST_NUM ')' {
			ArrayList arg = new ArrayList();
			arg.add(Integer.parseInt($temp.text));
			$return_type = ArrType.getInstance(CharType.getInstance(), arg);
			$line = $temp.getLine();
			$IsLvalue = 0;
			mips.readStr(Integer.parseInt($temp.text));

		}

	|	'(' tmp = expr ')' {
			if($tmp.IsLvalue == 1) 
				mips.addVariableToStack($tmp.return_type);
			$return_type = $tmp.return_type;
			$line = $tmp.line;
			$IsLvalue = 0;
		}
	;

CONST_NUM:
		[0-9]+
	;

CONST_CHAR:
		'\'' . '\''
	;

CONST_STR:
		'"' ~('\r' | '\n' | '"')* '"'
	;

NL:
		'\r'? '\n' { setText("new_line"); }
	;

ID:
		[a-zA-Z_][a-zA-Z0-9_]*
	;

COMMENT:
		'#'(~[\r\n])* -> skip
	;

WS:
    	[ \t] -> skip
    ;
