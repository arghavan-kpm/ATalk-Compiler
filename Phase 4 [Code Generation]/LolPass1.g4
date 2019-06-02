grammar LolPass1;

@members{
    
    void print(String str){
        System.out.println(str);
    }

    void putLocalVar(String name, Type type) throws ItemAlreadyExistsException {
        SymbolTable.top.put(
            new SymbolTableLocalVariableItem(
                new Variable(name, type),
                SymbolTable.top.getOffset(Register.SP)
            )
        );
    }

    void putStaticVar(String name, Type type) throws ItemAlreadyExistsException {
        SymbolTable.top.put(
            new SymbolTableStaticVariableItem(
                new Variable(name, type),
                SymbolTable.top.getOffset(Register.GP)
            )
        );
    }

    void beginScope() {
    	int localOffset = 0;
    	int globalOffset = 0;
    	
    	if(SymbolTable.top != null) {
        	localOffset = SymbolTable.top.getOffset(Register.SP);
        	globalOffset = SymbolTable.top.getOffset(Register.GP);
    	}

        SymbolTable.push(new SymbolTable(SymbolTable.top));

        SymbolTable.top.setOffset(Register.SP, localOffset);
        SymbolTable.top.setOffset(Register.GP, globalOffset);
    }
    
    void endScope() {
        print("Stack offset: " + SymbolTable.top.getOffset(Register.SP) + ", Global offset: " + SymbolTable.top.getOffset(Register.GP));
        
        if(SymbolTable.top.getPreSymbolTable() != null) {
            SymbolTable.top.getPreSymbolTable().setOffset(
                Register.GP,
                SymbolTable.top.getOffset(Register.GP)
            );
        }
        SymbolTable.pop();
    }
}

program
    :
    { 
        print("Pass1 started -------------------------");
        beginScope(); 
    }    
        (statement)*    
    {
        endScope();
        print("Pass1 finished -------------------------");
    }
    ;

statement
    : 
        vardef ';' 
    |   static_vardef ';'
    |   expr ';' 
    |   block
    ;

static_vardef
    :
        'static' var_type = type var_id = ID
        {
            try {
                putStaticVar($var_id.text, $var_type.return_type);
            }
            catch(ItemAlreadyExistsException e) {
                print(String.format("[Line #%s] Variable \"%s\" already exists.", $var_id.getLine(), $var_id.text));
            }
        }
    ;

vardef
    :   
        var_type = type var_id = ID
        {
            try {
                putLocalVar($var_id.text, $var_type.return_type);
            }
            catch(ItemAlreadyExistsException e) {
            	print(String.format("[Line #%s] Variable \"%s\" already exists.", $var_id.getLine(), $var_id.text));
            }
        }
    ;

type returns [Type return_type] 
    :
        'int' { $return_type = IntType.getInstance(); }
    ;

block
    : 
    	{ beginScope(); }
        '{' (statement)* '}'
    	{ endScope(); }
    ;

expr
    : 
        ('out' | expr_add) '<-' expr
    |   expr_add
    ;

expr_add
    :
        expr_mult expr_add_tmp
    ;

expr_add_tmp
    : 
        op=('+'|'-') expr_mult expr_add_tmp
    |
    ;

expr_mult
    : 
        expr_other expr_mult_tmp
    ;

expr_mult_tmp
    : 
        op=('*'|'/') expr_other expr_mult_tmp
    |
    ;

expr_other
    :
        CONST_INT
    |   ID 
    |   '(' expr ')'
    ;

CONST_INT:
        [0-9]+
    ;

ID:
        [a-zA-Z_][a-zA-Z0-9_]*
    ;

WS:
        [ \r\t\n]+ -> skip
    ;
