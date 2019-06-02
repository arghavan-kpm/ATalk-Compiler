grammar Phase1;

@members{
    void print(String str){
        System.out.println(str);
    }
}

WS:	[ \r\t]+ ;

Name1:	[a-zA-Z_]([a-zA-Z0-9_])* ;

Number:	[0-9]+ ;

name : Name1 {print("name");};

number_signed:	('-' Number | Number) {print("Signed");}  ;

number_unsigned : Number {print("Unsigned");};

wse: (WS)* {print("wse");};

ws : WS {print("ws");};

comment:	hashtag str {print("comment");};

hashtag:	('#') {print("hashtag");};

eol:	('\n') {print("eol");}	;

str:	(~('\n'))* {print("str");};

ascii_char : (~('\n') | ('\n')) {print("ascii_chars");};	/*  multiple       */

fl:	( wse comment eol | wse eol) {print("fl");};

actor_key:	  ('actor') {print("actor_key");};

char_key:	('char') {print("char_key");};

break_key:	('break') {print("break_key");};

else_key:	('else') {print("else_key");};

in_key:	('in') {print("in_key");};

read_key:	('read') {print("read_key");};

receiver_key:	('receiver') {print("receiver_key");};

quit_key:	('quit') {print("quit_key");};

if_key:	('if') {print("if_key");};

sender_key:		('sender') {print("sender_key");};

begin_key:	('begin') {print("begin_key");};

write_key:	('write') {print("write_key");};

int_key:	('int') {print("int_key");};

foreach_key:	('foreach') {print("foreach_key");};

elseif_key:	('elseif') {print("elseif_key");};

self_key:	('self') {print("self_key");};

end_key:	('end') {print("end_key");};

/* ************************************************************************************************************************************************************************************ */

line:	(sender_key wse ('<<') wse send | self_key wse ('<<') wse send |	name wse ('<<') wse send | decline | alloc fl  | quit_key fl | break_key fl) {print("line");};

send:	(name wse ('(') wse args wse (')') wse fl | name wse ('(') wse (')') wse fl) {print("send");} ;

args:	(exp | exp wse (',') wse args) {print("args");};

decline : (type(ws | arraydec) dec fl) {print("decline");};

dec: (assign wse (',') wse dec | name wse (',') wse dec | assign | name) {print("dec");} ;

assign:	(name wse op=('=' | '=') wse alloc){print("assign : " + $op.text);} | (exp | ('{') wse list wse ('}') ) {print("assign");};

type: (int_key | char_key) {print("type");};

arraydec:	(wse ('[') wse number_unsigned wse (']') wse )* {print("arraydec");};

array:	(('[') wse alloc wse (']'))* wse {print("array");};

alloc:	(name array wse op=('=' | '=') wse alloc){print("alloc : " + $op.text);} | ('{') wse list wse ('}') | exp {print("alloc");} ;

list:	(element wse (',') wse list | element) {print("list");};

element:	(alloc) {print("element");};

rEAD:	(read_key wse ('(') wse number_unsigned wse (')')) {print("rEAD");} ;		

wRITE: (write_key wse ('(') wse exp wse (')')) {print("wRITE");};	

exp: (exp1 ws op=('or' | 'or') ws exp) {print("exp : " + $op.text);} | (rEAD | wRITE | exp1) {print("exp");};

exp1 : (exp2 ws op=('and' | 'and') ws exp1) {print("exp1 : " + $op.text);} | (exp2 | rEAD | wRITE) {print("exp1");};

exp2 : (exp3 wse op=('==' | '<>') wse exp3) {print("exp2 : " + $op.text);} | (exp3 | rEAD | wRITE) {print("exp2");};
	
exp3 : (exp4 wse op=('<' | '>') wse exp4) {print("exp3 : " + $op.text);} | (exp4 | rEAD | wRITE) {print("exp3");};
	
exp4 : (exp5 wse op=('+' | '-') wse exp4) {print("exp4 : " + $op.text);} | (exp5 | rEAD | wRITE) {print("exp4");};
	
exp5 : (exp6 wse op=('*' | '/') wse exp5) {print("exp5 : " + $op.text);} | (exp6 | rEAD | wRITE) {print("exp5");};
	
exp6 : ( op=('-' | 'not') wse exp6) {print("exp6 : " + $op.text);} | (exp7 | rEAD | wRITE) {print("exp6");};
	
exp7 : (name wse array | exp8 | rEAD | wRITE) {print("exp7");};

exp8 : ( '(' wse alloc wse (')') | name | number_signed | '\'' ascii_char '\'' | '"' str '"') {print("exp8");};

funclist : (func)* {print("funclist");};

func : (wse (iF | fOR | bEGIN | wRITE fl| rEAD fl | line | fl)) {print("func");};	

bEGIN : (begin_key fl funclist wse end_key fl ) {print("bEGIN");};

fOR : (foreach_key ws name ws in_key ws alloc fl funclist wse end_key fl ) {print("fOR");} ;

eil : (eLSEIF)+ {print("eil");};

iF : (iff | if_else | if_elseif | if_elseif_else) {print("iF");} ;

iff : if_key ws alloc fl funclist wse end_key fl {print("iff");};

if_else : if_key ws alloc fl funclist wse else_key fl funclist wse end_key fl {print("if_else");};

eLSEIF : wse elseif_key ws alloc fl funclist {print("eLSEIF");};

if_elseif : if_key ws alloc fl funclist eil wse end_key fl {print("if_elseiff");};

if_elseif_else : if_key ws alloc fl funclist eil wse else_key fl funclist wse end_key fl {print("if_elseif_else");};
					
/* ****************************************************************************************************************************************************************************************** */

recv : (wse receiver_key ws op=(Name1 | Name1) wse '(' wse params wse ')' fl funclist wse end_key fl | wse receiver_key ws op=(Name1 | Name1) wse '(' wse ')' fl funclist wse end_key fl ) {print("recv : " + $op.text);};

params : (param wse ',' wse params | param) {print("params");};

param : type (ws | arraydec) name {print("param");};

global : wse type (ws | arraydec) namelist fl {print("global");};

namelist : (name wse ',' wse namelist | name) {print("namelist");} ;

/* ******************************************************************************************************************************************************************************************* */

actarg : (recv | global | fl) {print("actarg");};

actlist : (actarg)* {print("actlist");};

aCTOR : actor_key ws op=(Name1 | Name1) wse '<' wse number_unsigned wse '>' fl actlist wse end_key {print("aCTOR : " + $op.text);};

/* ***************************************************************************************************************************************************************************************** */

program : (aCTOR | fl)+ {print("program");};
