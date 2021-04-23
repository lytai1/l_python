grammar FeatherweightJavaScript;


@header { package edu.sjsu.fwjs.parser; }

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
VAR	  : 'var' ;
PRINT	  : 'print' ;
FUNCTION  : 'function' ;
WHILE	  : 'while' ;

// Literals
INT       : [1-9][0-9]* | '0' ;
BOOL	  : 'true' | 'false' ;
NULL	  : 'null' ;
ID	  : [a-zA-Z_][a-zA-Z_0-9]*;


// Symbols
MUL       : '*' ;
DIV       : '/' ;
MOD       : '%' ;
ADD       : '+' ;
SUB       : '-' ;
GT	  : '>' ;
GTE	  : '>=' ;
LT	  : '<' ;
LTE	  : '<=' ;
EQ	  : '==' ;
SEPARATOR : ';' ;


// Whitespace and comments
NEWLINE   : '\r'? '\n' -> skip ;
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
BLOCK_COMMENT  : '/*' .*? '*/' -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace


// ***Parsing rules ***

/** The start rule */
prog: stat+ ;

stat: expr SEPARATOR                                    # bareExpr
    | IF '(' expr ')' block ELSE block                  # ifThenElse
    | IF '(' expr ')' block                             # ifThen
    | WHILE'(' expr ')' block                           # while
    | PRINT '(' expr ')' SEPARATOR			# print
    | SEPARATOR						# emptExpr
    ;

expr: expr op=( '*' | '/' | '%' ) expr                  # MulDivMod
    | expr op=( '+' | '-' ) expr                  	# AddSub
    | expr op=( '>' | '>=' | '<' | '<=' |'==' ) expr    # EqualityOp
    | FUNCTION '(' (ID (',' ID)*)? ')' block		# functDeclare
    | expr '(' (expr (',' expr)*)? ')'			# functApp
    | VAR ID '=' expr 					# varDeclare
    | ID '=' expr 					# varAssign
    | INT                                               # int
    | BOOL						# bool
    | NULL						# null
    | ID						# id
    | '(' expr ')'                                      # parens
    ;

block: '{' stat* '}'                                    # fullBlock
     | stat                                             # simpBlock
     ;

