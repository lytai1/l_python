/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Bart Kiers
 * Copyright (c) 2019 Robert Einhorn
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * Project      : Python3-parser; an ANTLR4 grammar for Python 3
 *                https://github.com/bkiers/Python3-parser
 * Developed by : Bart Kiers, bart@big-o.nl
 *
 * Project      : an ANTLR4 grammar for Tiny Python without embedded actions
 *                https://github.com/antlr/grammars-v4/tree/master/python/tiny-python/tiny-grammar-without-actions
 * Developed by : Robert Einhorn, robert.einhorn.hu@gmail.com
 *https://stackoverflow.com/questions/8642154/antlr-what-is-simpliest-way-to-realize-python-like-indent-depending-grammar
 */

// Based on the Bart Kiers's ANTLR4 Python 3.3 grammar: https://github.com/bkiers/Python3-parser
// and the Python 3.3.7 Language Reference:             https://docs.python.org/3.3/reference/grammar.html
grammar LightPython;


@header { package edu.sjsu.lpython.parser; }

tokens { INDENT, DEDENT }
@lexer::members {
  // A queue where extra tokens are pushed on (see the NEWLINE lexer rule).
  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
  // The stack that keeps track of the indentation level.
  private java.util.Stack<Integer> indents = new java.util.Stack<>();
  // The amount of opened braces, brackets and parenthesis.
  private int opened = 0;
  // The most recently produced token.
  private Token lastToken = null;
  @Override
  public void emit(Token t) {
    super.setToken(t);
    tokens.offer(t);
  }

  @Override
  public Token nextToken() {
    // Check if the end-of-file is ahead and there are still some DEDENTS expected.
    if (_input.LA(1) == EOF && !this.indents.isEmpty()) {
      // Remove any trailing EOF tokens from our buffer.
      for (int i = tokens.size() - 1; i >= 0; i--) {
        if (tokens.get(i).getType() == EOF) {
          tokens.remove(i);
        }
      }

      // First emit an extra line break that serves as the end of the statement.
      this.emit(commonToken(LightPythonParser.NEWLINE, "\n"));

      // Now emit as much DEDENT tokens as needed.
      while (!indents.isEmpty()) {
        this.emit(createDedent());
        indents.pop();
      }

      // Put the EOF back on the token stream.
      this.emit(commonToken(LightPythonParser.EOF, "<EOF>"));
    }

    Token next = super.nextToken();

    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
      // Keep track of the last token on the default channel.
      this.lastToken = next;
    }

    return tokens.isEmpty() ? next : tokens.poll();
  }

  private Token createDedent() {
    CommonToken dedent = commonToken(LightPythonParser.DEDENT, "");
    dedent.setLine(this.lastToken.getLine());
    return dedent;
  }

  private CommonToken commonToken(int type, String text) {
    int stop = this.getCharIndex() - 1;
    int start = text.isEmpty() ? stop : stop - text.length() + 1;
    return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
  }

  // Calculates the indentation of the provided spaces, taking the
  // following rules into account:
  //
  // "Tabs are replaced (from left to right) by one to eight spaces
  //  such that the total number of characters up to and including
  //  the replacement is a multiple of eight [...]"
  //
  //  -- https://docs.python.org/3.1/reference/lexical_analysis.html#indentation
  static int getIndentationCount(String spaces) {
    int count = 0;
    for (char ch : spaces.toCharArray()) {
      switch (ch) {
        case '\t':
          count += 8 - (count % 8);
          break;
        default:
          // A normal space char.
          count++;
      }
    }

    return count;
  }

  boolean atStartOfInput() {
    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
  }
}
/*
 * parser rules
 */

// startRules:
single_input: NEWLINE | simple_stmt | compound_stmt NEWLINE;
file_input:  (NEWLINE | stmt)* EOF?;

stmt: simple_stmt | compound_stmt;

simple_stmt: small_stmt NEWLINE;
small_stmt: assignment_stmt 
          // | flow_stmt 
          | print_stmt;
assignment_stmt: NAME '=' expr;
// flow_stmt: break_stmt | continue_stmt;
//break_stmt: 'break';
//continue_stmt: 'continue';

compound_stmt: if_stmt | while_stmt;
if_stmt: 'if' test ':' suite ('elif' test ':' suite)* ('else' ':' suite)?;
while_stmt: 'while' test ':' suite;
suite: simple_stmt #suite1
      | NEWLINE INDENT stmt+ DEDENT #suite2
      ; 

test: 'not' test #Not
    | test aon_op test #BoolOp
    | expr comp_op expr #CompOp
    | expr #TestExpr
; 
print_stmt: 'print' expr; // only for demonstration
aon_op: 'and' | 'or';
comp_op: '<' | '>' | '==' | '>=' | '<=' | '!=';
expr:
   expr op=( '*' | '/' | '%' ) expr #MulDivMod
 | expr op=( '+' | '-' ) expr #AddSub
 | sign=( '+' | '-' ) atom #negposNum
 | atom trailer* #AtomTrailer
 ;
atom:
   NAME #Var
 | NUMBER #Int
 | STRING #string
 | BOOLEAN #boolean
 | NONE #none
 |'[' test (',' test )* ','? ']' #list
 | '(' expr ')' #paren
;


trailer: '[' subscriptlist ']';
subscriptlist: subscript (',' subscript)* ','?;
subscript: test | test? ':' test? sliceop?;
sliceop: ':' test?;

/*
 * lexer rules
 */
BOOLEAN: 'True' | 'False';
NONE: 'None';
STRING
 : STRING_LITERAL
 ;

NUMBER
 : INTEGER
 ;

INTEGER
 : DECIMAL_INTEGER
 ;

NEWLINE
 : ( {atStartOfInput()}?   SPACES
   | ( '\r'? '\n' | '\r' ) SPACES?
   )
   {
     String newLine = getText().replaceAll("[^\r\n]+", "");
     String spaces = getText().replaceAll("[\r\n]+", "");
     int next = _input.LA(1);
     if (opened > 0 || next == '\r' || next == '\n' || next == '#') {
       // If we're inside a list or on a blank line, ignore all indents, 
       // dedents and line breaks.
       skip();
     }
     else {
       emit(commonToken(NEWLINE, newLine));
       int indent = getIndentationCount(spaces);
       int previous = indents.isEmpty() ? 0 : indents.peek();
       if (indent == previous) {
         // skip indents of the same size as the present indent-size
         skip();
       }
       else if (indent > previous) {
         indents.push(indent);
         emit(commonToken(LightPythonParser.INDENT, spaces));
       }
       else {
         // Possibly emit more than 1 DEDENT token.
         while(!indents.isEmpty() && indents.peek() > indent) {
           this.emit(createDedent());
           indents.pop();
         }
       }
     }
   }
 ;

NAME
 : ID_START ID_CONTINUE*
 ;

STRING_LITERAL
 : '"' .*? '"' 
 ;

DECIMAL_INTEGER
 : NON_ZERO_DIGIT DIGIT*
 | '0'+
 ;

OPEN_PAREN : '(';
CLOSE_PAREN : ')';
OPEN_BRACK : '[';
CLOSE_BRACK : ']';
OPEN_BRACE : '{';
CLOSE_BRACE : '}';

SKIP_
 : ( SPACES | COMMENT | LINE_JOINING ) -> skip
 ;

UNKNOWN_CHAR
 : .
 ;


/* 
 * fragments 
 */

fragment NON_ZERO_DIGIT
 : [1-9]
 ;

fragment DIGIT
 : [0-9]
 ;

fragment SPACES
 : [ \t]+
 ;

fragment COMMENT
 : '#' ~[\r\n\f]*
 | '"""' .*? '"""'
 | '\'\'\'' .*? '\'\'\''
 ;

fragment LINE_JOINING
 : '\\' SPACES? ( '\r'? '\n' | '\r' | '\f' )
 ;

fragment ID_START
 : '_'
 | [A-Z]
 | [a-z]
 ;

fragment ID_CONTINUE
 : ID_START
 | [0-9]
 ;
