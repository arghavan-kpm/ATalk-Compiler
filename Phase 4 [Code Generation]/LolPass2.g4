grammar LolPass2;

@members{

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

    Translator mips = new Translator();
}

program
    :
    {
        print("Pass2 started -------------------------");
        beginScope();
    }
        (statement)*
    {
        endScope();
        print("Pass2 finished -------------------------");
        mips.makeOutput();
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
            SymbolTableItem item = SymbolTable.top.get($var_id.text);
            SymbolTableVariableItemBase var = (SymbolTableVariableItemBase) item;
            print($var_id.line + ") Variable " + $var_id.text + " used.\t\t" +   "Base Reg: " + var.getBaseRegister() + ", Offset: " + var.getOffset());
            mips.addGlobalVariable(var.getOffset(), -1);
        }
    ;

vardef
    :
        var_type = type var_id = ID
        {
            SymbolTable.define();
            mips.addToStack(0);
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

expr returns [boolean is_lvalue]
    :
        (
            'out' '<-' expr
            {
                $is_lvalue = false;
                mips.write();
            }
            |
            expression_add = expr_add [true] op = '<-' expr
            {
                if(!$expression_add.is_lvalue)
                    print($op.line + ") Cannot assign a value to rvalue expression.");
                $is_lvalue = true;
                mips.assignCommand();
            }
        )
    |   expression_add = expr_add [false]
        { $is_lvalue = $expression_add.is_lvalue; }
    ;

expr_add [boolean is_left] returns [boolean is_lvalue]
    :
        expression_mult = expr_mult [$is_left] expression_add = expr_add_tmp
        { $is_lvalue = $expression_mult.is_lvalue && !$expression_add.has_value; }
    ;

expr_add_tmp returns [boolean has_value]
    :
        op=('+'|'-') expr_mult [false]
        {
            mips.operationCommand($op.text);
        } expr_add_tmp
        { $has_value = true; }
    |   { $has_value = false; }
    ;

expr_mult [boolean is_left] returns [boolean is_lvalue]
    :
        expression_other = expr_other [$is_left] expression_mult = expr_mult_tmp
        { $is_lvalue = $expression_other.is_lvalue && !$expression_mult.has_value; }
    ;

expr_mult_tmp returns [boolean has_value]
    :
        op=('*'|'/') expr_other [false]
        {
            mips.operationCommand($op.text);
        } expr_mult_tmp
        { $has_value = true; }
    |   { $has_value = false; }
    ;

expr_other [boolean is_left] returns [boolean is_lvalue]
    :
        num = CONST_INT
        {
            $is_lvalue = false;
            mips.addToStack(Integer.parseInt($num.text));
        }
    |   id = ID
        {
            SymbolTableItem item = SymbolTable.top.get($id.text);
            if(item == null) {
                print($id.line + ") Item " + $id.text + " doesnt exist.");
            }
            else {
                SymbolTableVariableItemBase var = (SymbolTableVariableItemBase) item;
                print($id.line + ") Variable " + $id.text + " used.\t\t" +   "Base Reg: " + var.getBaseRegister() + ", Offset: " + var.getOffset());
                if (var.getBaseRegister() == Register.SP){
                    if ($is_left == false) mips.addToStack($id.text, var.getOffset()*-1);
                    else mips.addAddressToStack($id.text, var.getOffset()*-1);
                }
                else {
                    if ($is_left == false) mips.addGlobalToStack(var.getOffset());
                    else mips.addGlobalAddressToStack($id.text, var.getOffset());
                }
            }
            $is_lvalue = true;
        }
    |   '(' expression = expr ')' { $is_lvalue = $expression.is_lvalue; }
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
