grammar AtalkPass1;

@header{
	import java.util.*;
}

@members{
	int actorCnt = 0;
	int IsInFor = 0;
	int IsThereErr = 0;
	String PrintOut = "";
    ArrayList Dim = new ArrayList();
    ArrayList args = new ArrayList();
    void print(String str){
        System.out.println(str);
    }

    void putLocalVar(String name, Type type) throws ItemAlreadyExistsException {
        PrintOut += "var name: " + name + " var type: " + type.toString() + " offset: " + Integer.toString(SymbolTable.top.getOffset(Register.SP)) + " var size: " + Integer.toString(type.size()) + "\n";
        SymbolTable.top.put(
            new SymbolTableLocalVariableItem(
                new Variable(name, type),
                SymbolTable.top.getOffset(Register.SP)
            )
        );
    }

    void addActor(String name, ArrayList arg) throws ItemAlreadyExistsException {
    	SymbolTable.top.put( new ActorType(name, arg) );
    }

    void addReceiver(String name,ArrayList args) throws ItemAlreadyExistsException {
   		SymbolTable.top.getPreSymbolTable().put( new ReceiveType(name,args) );			
    }
    
    void addLocalVar(String name,Type type,int line){
    	try {
            putLocalVar(name, type);

        }
        catch(ItemAlreadyExistsException e) {
        	print(String.format("[Line #%s] Variable \"%s\" already exists.", line, name));
        	IsThereErr = 1;

        	String s = name + "_Temporary_";
	        	int cnt = 1;
	        	while(true){
	        		try{
	        			putLocalVar(s + Integer.toString(cnt), type);
	        		}
	        		catch(ItemAlreadyExistsException exp){
	        			cnt++;
	        			continue;
	        		}
	        		break;
	        	}
        }
    }

    void addActorVar(String name,Type type,int line){
    	try {
            PrintOut += "var name: " + name + " var type: " + type.toString() + " offset: " + Integer.toString(SymbolTable.top.getOffset(Register.GP)) + " var size: " + Integer.toString(type.size()) + "\n";
	        SymbolTable.top.put(
	            new SymbolTableActorVariableItem(
	                new Variable(name, type),
	                SymbolTable.top.getOffset(Register.GP)
	            )
	        );

        }
        catch(ItemAlreadyExistsException e) {
        	print(String.format("[Line #%s] Variable \"%s\" already exists.", line, name));
        	IsThereErr = 1;

        	String s = name + "_Temporary_";
	        	int cnt = 1;
	        	while(true){
	        		try{
	        			 SymbolTable.top.put(
				            new SymbolTableActorVariableItem(
				                new Variable(s + Integer.toString(cnt), type),
				                SymbolTable.top.getOffset(Register.GP)
				            )
				        );
	        		}
	        		catch(ItemAlreadyExistsException exp){
	        			cnt++;
	        			continue;
	        		}
	        		break;
	        	}
        }
    }

    void beginScope() {
    	int soffset = 0;
    	int goffset = 0;
    	if(SymbolTable.top != null){
        	soffset = SymbolTable.top.getOffset(Register.SP);
        	goffset = SymbolTable.top.getOffset(Register.GP);

    	}
        SymbolTable.push(new SymbolTable(SymbolTable.top));
        SymbolTable.top.setOffset(Register.SP, soffset);
        SymbolTable.top.setOffset(Register.GP, goffset);
       
    }
    
    void endScope() {
        print("Stack offset: " + SymbolTable.top.getOffset(Register.SP));
        SymbolTable.pop();
    }
}

program:
	{beginScope();}
		(actor | NL)*

	{	
		if(actorCnt == 0){
			print("No actor<> exists");
			IsThereErr = 1;
		}
		endScope();   
		if(IsThereErr == 0){
			print(PrintOut);
		}
	}
	;

actor:
		'actor' act_id = ID '<' num=CONST_NUM '>' NL  
		
		{
			beginScope();
			PrintOut += "actor name: " + $act_id.text + " queue length: " + $num.text + "\n";
			actorCnt++;
			ArrayList arg = new ArrayList();
		}
			(state 
			| recv = receiver 
				{
					arg.add($recv.signature);
				}
			| NL
			)*

		'end' (NL | EOF)
		{ endScope(); }
			
		{ 
			if(Integer.parseInt($num.text) <= 0){
				print(String.format("[Line #%d] Actor mailbox size must be more than 0", $num.getLine() )); 
				IsThereErr = 1;
			}

			try {
            	addActor($act_id.text, arg);
	        }
	        catch(ItemAlreadyExistsException e) {
	        	print(String.format("[Line #%s] Actor \"%s\" already exists.", $act_id.getLine(), $act_id.text));
	        	IsThereErr = 1;

	        	String s = $act_id.text + "_Temporary_";
	        	int cnt = 1;
	        	while(true){
	        		try{
	        			addActor(s + Integer.toString(cnt), arg);
	        		}
	        		catch(ItemAlreadyExistsException exp){
	        			cnt++;
	        			continue;
	        		}
	        		break;
	        	}
	        }
		}

	;

state:
		var_type = type var_id = ID { addActorVar( $var_id.text,$var_type.return_type,$var_id.getLine() ); } 
		(',' var_id = ID { addActorVar( $var_id.text,$var_type.return_type,$var_id.getLine() ); } )* NL
	;

receiver returns [String signature]:
		{ beginScope(); }
		{ args.clear(); }
		'receiver' recv_id = ID '(' (var_type = type var_id = ID { args.add($var_type.return_type.toString()); addLocalVar( $var_id.text,$var_type.return_type,$var_id.getLine() ); } 
			(','var_type = type var_id = ID { args.add($var_type.return_type.toString()); addLocalVar( $var_id.text,$var_type.return_type,$var_id.getLine() ); }  )*)? ')' NL
		{ 
			try {
            	addReceiver($recv_id.text,args);
            	PrintOut += "Receiver signature: " + new ReceiveType($recv_id.text, args).getKey() + "\n";
            	$signature = new  ReceiveType($recv_id.text, args).getKey();
	        }
	        catch(ItemAlreadyExistsException e) {
	        	print(String.format("[Line #%s] Receiver \"%s\" already exists.", $recv_id.getLine(), $recv_id.text));
	        	IsThereErr = 1;

	        	String s = $recv_id.text + "_Temporary_";
	        	int cnt = 1;
	        	while(true){
	        		try{
	        			addReceiver(s + Integer.toString(cnt), args);
	        		}
	        		catch(ItemAlreadyExistsException exp){
	        			cnt++;
	        			continue;
	        		}
	        		break;
	        	}
	        }
		}

			statements
		'end' NL
		{ endScope(); }
	;

type	returns [Type return_type] 
	:
		'char' { Dim.clear(); } ('[' tmp = CONST_NUM ']' { 

			Dim.add( $tmp.text ); 
			if(Integer.parseInt($tmp.text) <= 0) {
				print(String.format("[Line #%d] Array size must be more than 0", $tmp.getLine() )); 
				IsThereErr = 1;
			}

			} )* 

		{ 
			
			if(Dim.size() == 0)
				$return_type = CharType.getInstance();  
			else
				$return_type = ArrType.getInstance(CharType.getInstance(), Dim);
		}
	|	'int' { Dim.clear(); } ('[' tmp = CONST_NUM ']' { 
			Dim.add( $tmp.text ); 
			if(Integer.parseInt($tmp.text) <= 0) {
				print(String.format("[Line #%d] Array size must be more than 0", $tmp.getLine() )); 
				IsThereErr = 1;
			}
				})* 

		{ 
			if(Dim.size() == 0)
				$return_type = IntType.getInstance();  
			else
				$return_type = ArrType.getInstance(IntType.getInstance(), Dim);
		}
	;

block:
		{ beginScope();}
		'begin' NL
			statements
		'end' NL
		{ endScope();}
	;

statements:
		(statement | NL)*
	;

statement:
		stm_vardef
	|	stm_assignment
	|	stm_foreach
	|	stm_if_elseif_else
	|	stm_quit
	|	stm_break
	|	stm_tell
	|	stm_write
	|	block
	;

stm_vardef:
		var_type = type var_id = ID { addLocalVar( $var_id.text,$var_type.return_type,$var_id.getLine() ); }  ('=' expr)? 
		(',' var_id = ID { addLocalVar( $var_id.text,$var_type.return_type,$var_id.getLine() ); }  ('=' expr)?)* NL
	;

stm_tell:
		(ID | 'sender' | 'self') '<<' ID '(' (expr (',' expr)*)? ')' NL
	;

stm_write:
		'write' '(' expr ')' NL
	;

stm_if_elseif_else:
		 { beginScope(); }
		'if' expr NL statements
		{ endScope(); }
		(
			{ beginScope(); }
			'elseif' expr NL statements
			{ endScope(); }
		)*
		(
			{ beginScope(); }
			'else' NL statements
			{ endScope(); }
		)?
		'end' NL
	;

stm_foreach:
		{ beginScope(); }
		'foreach' temp = ID 'in' expr NL   	/* TODO : add ID to symboltable */
			{
				IsInFor = 1;
				addLocalVar($temp.text,NoType.getInstance(),$temp.getLine());
			}
			statements
		'end' NL
		{IsInFor = 0;}
		{ endScope(); }
	;

stm_quit:
		'quit' NL
	;

stm_break:
		'break' NL
		{if(IsInFor == 0)
			print("break out of for");
		}
	;

stm_assignment:
		expr NL
	;

expr:
		expr_assign
	;

expr_assign:
		expr_or '=' expr_assign
	|	expr_or
	;

expr_or:
		expr_and expr_or_tmp
	;

expr_or_tmp:
		'or' expr_and expr_or_tmp
	|
	;

expr_and:
		expr_eq expr_and_tmp
	;

expr_and_tmp:
		'and' expr_eq expr_and_tmp
	|
	;

expr_eq:
		expr_cmp expr_eq_tmp
	;

expr_eq_tmp:
		('==' | '<>') expr_cmp expr_eq_tmp
	|
	;

expr_cmp:
		expr_add expr_cmp_tmp
	;

expr_cmp_tmp:
		('<' | '>') expr_add expr_cmp_tmp
	|
	;

expr_add:
		expr_mult expr_add_tmp
	;

expr_add_tmp:
		('+' | '-') expr_mult expr_add_tmp
	|
	;

expr_mult:
		expr_un expr_mult_tmp
	;

expr_mult_tmp:
		('*' | '/') expr_un expr_mult_tmp
	|
	;

expr_un:
		('not' | '-') expr_un
	|	expr_mem
	;

expr_mem:
		expr_other expr_mem_tmp
	;

expr_mem_tmp:
		'[' expr ']' expr_mem_tmp
	|
	;

expr_other:
		CONST_NUM
	|	CONST_CHAR
	|	CONST_STR
	|	ID
	|	'{' expr (',' expr)* '}'
	|	'read' '(' CONST_NUM ')'
	|	'(' expr ')'
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