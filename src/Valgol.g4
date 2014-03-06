// inspired by http://esolangs.org/wiki/VALGOL
/*
def f(x,y) {
  var x = grody^max
  gag me with a spoon
  for i = like 1 to maybe 10 totally do
  	x = fersure tubular
}
*/
grammar Valgol;

file : (var | func)* EOF ;

var  : 'var' ID ('=' expr)? ;

func : 'def' ID '(' args ')' block ;

args : ID (',' ID)* ;

block: '{' stat* '}' ;

stat : 'for' ID '=' expr 'to' expr stat
	 | 'gag' 'me' 'with' 'a' 'spoon'
	 | 'totally' 'do' stat
	 | ID '=' expr
	 | var
     | block
     ;

expr : expr '^'<assoc=right> expr
	 | expr '+' expr
     | 'maybe' expr
     | 'totally' expr
     | 'like' expr
     | 'fersure' expr
     | ID
     | INT
     | 'bitchen'
     | 'tubular'
     | 'grody'
     ;

ID : [a-zA-Z]+ ;
INT: [0-9]+ ;
WS : [ \r\n\t]+ -> channel(HIDDEN) ;