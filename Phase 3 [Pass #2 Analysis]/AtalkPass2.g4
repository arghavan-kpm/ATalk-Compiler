grammar AtalkPass2;

@members{
	int IsInit = 0;
	int IsElementArrNotProper = 0;
	int forStack = 0;
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

}

program:
	{ 
        print("Pass2 started -------------------------");
        beginScope(); 
    } 
		(actor | NL)*
	{
        endScope();
        print("Pass2 finished -------------------------");
    }
	;

actor:
		'actor' ID '<' CONST_NUM '>' NL
		{beginScope(); }
			(state | receiver | NL)*

		'end' (NL | EOF)
		{endScope(); }
	;

state:
		type ID (',' ID)* NL
	;

receiver:

		{ int cnt = 0;}
		'receiver' temp = ID '(' (type ID { cnt = 1; SymbolTable.define(); } (',' type ID { SymbolTable.define(); })*)? ')' NL

			{
				beginScope(); 

				if(($temp.text.equals("init") == true) && (cnt == 0))
					IsInit = 1;
			}
			statements
		'end' NL
		{
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
		}
		'begin' NL
			statements
		'end' NL
		{endScope(); }
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
		type id=ID { SymbolTable.define(); } ('=' temp=expr 
			{
				SymbolTableLocalVariableItem item = (SymbolTableLocalVariableItem)SymbolTable.top.get($id.text);

				if($temp.return_type.toString().equals(item.getVariable().getType().toString()) == false ){
					print(String.format("[Line #%s] assignment unavailable", $temp.line));
				}
			}
		)? 
		(',' ID { SymbolTable.define(); } ('=' tmp=expr 
			{
				SymbolTableLocalVariableItem item = (SymbolTableLocalVariableItem)SymbolTable.top.get($id.text);

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

			SymbolTableItem item = SymbolTable.top.get($id.text);
			//System.err.println("Hello");
            if(item == null) 
                print(String.format("[Line #%s] actor \"%s\" doesn't exist.", $id.getLine(), $id.text));
		}
		| id = 'sender'
			{
				TELL = "sender";
				if(IsInit == 1)
					print(String.format("[Line #%s] \"init\" receiver has no access to sender actor.", $id.getLine()));
			}
		| 'self' 
			{
				TELL = "self";
			}
		) 
		{
			ArrayList arg = new ArrayList();
		}
		'<<' temp = ID '(' (Tmp=expr {arg.add($Tmp.return_type);}(',' tmp=expr {arg.add($tmp.return_type);})*)? ')' NL
		{
			String sign = new ReceiveType($temp.text, arg).getKey();

			if(TELL.equals("self") == true){
				SymbolTableItem item = SymbolTable.top.get(sign);
				if(item == null) 
                	print(String.format("[Line #%s] this actor has not receiver \"%s\".", $temp.getLine(), sign));
			}
			else if(TELL.equals("sender") == true){/*EMTIAZI*/

			}
			else{
				SymbolTableItem item = SymbolTable.top.get(TELL);
				if(item != null){
					int haveRecv = 0;
					ActorType casted = (ActorType)item;
					for(int i=0; i<casted.Recv.size(); i++){
						if(casted.Recv.get(i).equals(sign) == true){
							haveRecv = 1;
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

			}
			else{
				print(String.format("[Line #%s] \"write\" operation in not valid.", $temp.line));
			}
		}
		')' NL
	;

stm_if_elseif_else:
		{
			beginScope();
			SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
		}
		'if' temp = expr
		{
			if($temp.return_type.toString().equals("int") == false){
				print(String.format("[Line #%s] if condition is invalid.", $temp.line));
			}
		} 
		NL statements
		{endScope();}
		(
			{
				beginScope(); 
				SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
			}
			'elseif' tmp = expr
			{
				if($tmp.return_type.toString().equals("int") == false){
				print(String.format("[Line #%s] if condition is invalid.", $tmp.line));
			}
			}
			 NL statements
			{endScope();}
		)*
		
		(
			{
				beginScope();
				SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
			}
			'else' NL statements
			{endScope();}
		)?
		'end' NL
	;

stm_foreach:
		{beginScope(); int thisForVar = 0;}
		'foreach' temp = ID 'in' tmp=expr NL
		{
			if($tmp.return_type instanceof ArrType){
				ArrType G = (ArrType)$tmp.return_type;
				if(G.dimension.size() == 1){ 
				        SymbolTable.top.replace($temp.text ,
				            new SymbolTableLocalVariableItem(
				                new Variable($temp.text, G.base),
				                SymbolTable.top.getOffset(Register.SP)
				            )
				        );
				        SymbolTable.define();
				        SymbolTableVariableItemBase castedItem = (SymbolTableVariableItemBase)SymbolTable.top.get($temp.text);  
				        thisForVar = G.base.size();
				        forStack += G.base.size();  
				        SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
				}
				else{
					ArrayList arg = new ArrayList(G.dimension.subList(1, G.dimension.size()));
			        SymbolTable.top.replace($temp.text,
			            new SymbolTableLocalVariableItem(
			                new Variable($temp.text, ArrType.getInstance(G.base, arg)),
			                SymbolTable.top.getOffset(Register.SP)
			            )
			        );
			        SymbolTable.define();
				    SymbolTableVariableItemBase castedItem = (SymbolTableVariableItemBase)SymbolTable.top.get($temp.text);  
				    thisForVar = castedItem.getSize();  
				    forStack += castedItem.getSize();
				    SymbolTable.top.setOffset(Register.SP,SymbolTable.top.getOffset(Register.SP) + forStack);
				}
			}
			else{
				print(String.format("[Line #%s] can not iterate in non array variable.", $tmp.line));
			}
		}
			statements
		'end' NL
		{endScope(); forStack -= thisForVar;}
	;

stm_quit:
		'quit' NL
	;

stm_break:
		'break' NL
	;

stm_assignment:
		expr NL
	;

expr returns [Type return_type, int line]:
		temp = expr_assign
		{
			$return_type = $temp.return_type;
			$line = $temp.line;	
		}
	;

expr_assign returns [Type return_type, int line]:
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
		}
	|	temp = expr_or 
		{
			$return_type = $temp.return_type;
			$line = $temp.line;
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
			if($tmp.return_type != null)
				$IsLvalue = 0;
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_or_tmp returns [Type return_type, int line]:
		'or' temp=expr_and expr_or_tmp
		{
			if( ($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] \"or\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
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
			if($tmp.return_type != null)
				$IsLvalue = 0;
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_and_tmp returns [Type return_type, int line]:
		'and' temp=expr_eq expr_and_tmp
		{
			if( ($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] \"and\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
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
 			if($tmp.return_type != null)
				$IsLvalue = 0;
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_eq_tmp returns [Type return_type, int line]:
		('==' | '<>') temp = expr_cmp tmp = expr_eq_tmp
		{
			if($tmp.return_type != null){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] multiple comparison can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
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
 			if($tmp.return_type != null)
				$IsLvalue = 0;
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_cmp_tmp returns [Type return_type, int line]:
		('<' | '>') temp = expr_add tmp = expr_cmp_tmp
		{
			if($tmp.return_type != null){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] multiple comparison can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
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
			if($tmp.return_type != null)
				$IsLvalue = 0;
			else
				$IsLvalue = $temp.IsLvalue;
		}
	;

expr_add_tmp returns [Type return_type, int line]:
		('+' | '-') temp=expr_mult expr_add_tmp
		{
			if(($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] \"+\" or \"-\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
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
			if($tmp.return_type != null)
				$IsLvalue = 0;
			else
				$IsLvalue = $temp.IsLvalue;
			
		}
	;

expr_mult_tmp returns [Type return_type, int line]:
		('*' | '/') temp = expr_un expr_mult_tmp
		{
			if(($temp.return_type.toString().equals("int") == false) && ($temp.return_type.toString().equals("NoType") == false) ){
				$return_type = NoType.getInstance();
				$line = $temp.line;
				print(String.format("[Line #%s] \"*\" or \"/\" can't be used.", $temp.line));
			}
			else{
				$return_type = $temp.return_type;
				$line = $temp.line;
			}
		}
	| 
	;

expr_un returns [Type return_type, int line, int IsLvalue]:
		('not' | '-') tmp = expr_un
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
				if($mem_cnt.cnt < tmp.dimension.size())
					$return_type = ArrType.getInstance(tmp.base, new ArrayList(tmp.dimension.subList($mem_cnt.cnt, tmp.dimension.size())));
				if($mem_cnt.cnt == tmp.dimension.size())
					$return_type = tmp.base;
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
		}

	|	temp = CONST_CHAR {
			$return_type = CharType.getInstance();
			$line = $temp.getLine();
			$IsLvalue = 0;
		}

	|	temp = CONST_STR 
		{
			ArrayList arg = new ArrayList();
			arg.add($temp.text.length() - 2);
			$return_type = ArrType.getInstance(CharType.getInstance(), arg); 
			$line = $temp.getLine();
			$IsLvalue = 0;
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
			Temp= expr (',' tmp = expr 
			{		
				ElementCounter += 1;
				if($Temp.return_type.toString().equals($tmp.return_type.toString()) == false) {
					$return_type = NoType.getInstance();
					$line = $Temp.line;
					IsElementArrNotProper = 1;
					print(String.format("[Line #%s] elements are not from the same type.", $Temp.line));
				}
			}
		)* '}'

	{
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
		}

	|	'(' tmp = expr ')' {					
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