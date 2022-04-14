package parser;

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;

import interpreter.Interpreter;

%%

%public
%class Lexer
%cup
%implements sym
%char
%line
%column

%{
    StringBuffer string = new StringBuffer();
    public Lexer(java.io.Reader in, ComplexSymbolFactory sf){
	this(in);
	symbolFactory = sf;
    }
    ComplexSymbolFactory symbolFactory;

  private Symbol symbol(String name, int sym) {
      return symbolFactory.newSymbol(name, sym, new Location(yyline+1,yycolumn+1,yyline+1), new Location(yyline+1,yycolumn+yylength(),yycolumn+1));
  }
  
  private Symbol symbol(String name, int sym, Object val) {
      Location left = new Location(yyline + 1, yycolumn + 1, yyline + 1);
      Location right = new Location(yyline + 1, yycolumn + yylength(), yycolumn + 1);
      return symbolFactory.newSymbol(name, sym, left, right, val);
  } 
  /*private Symbol symbol(String name, int sym, Object val, int buflength) {
      Location left = new Location(yyline + 1, yycolumn + yylength() - buflength, yychar + yylength() - buflength);
      Location right = new Location(yyline + 1, yycolumn + yylength(), yychar + yylength());
      return symbolFactory.newSymbol(name, sym, left, right, val);
  }*/      
  private void error(String message) {
    System.out.println("Error at line "+ (yyline + 1) + ", column " + (yycolumn + 1) + " : " + message);
  }
%} 

%eofval{
     return symbolFactory.newSymbol("EOF", EOF, new Location(yyline + 1, yycolumn + 1, yychar), new Location(yyline + 1, yycolumn + 1, yychar + 1));
%eofval}


Ident = [a-zA-Z$_] [a-zA-Z0-9$_]*

IntLiteral = 0 | [1-9][0-9]*

new_line = \r|\n|\r\n;

white_space = {new_line} | [ \t\f]

%%

/*A Scanner simply turns an input String (say a file) 
into a list of tokens. These tokens represent things like identifiers, parentheses, operators etc.*/

<YYINITIAL>{

"nil"             { return symbol("nil", NIL); }
"int"             { return symbol("int", INT); }
"Ref"             { return symbol("Ref", REF); }
"Q"               { return symbol("Q", Q); }
"mutable"         { return symbol("mutable", MUTABLE); }
"return"          { return symbol("return",  RETURN);}
"while"           { return symbol("while", WHILE);}  
"if"              { return symbol("if", IF);}  
"else"            { return symbol("else", ELSE); }   
"print"           { return symbol("print",  PRINT); }   

"{"               { return symbol("{",  RCURLY); }
"}"               { return symbol("}", LCURLY); }    
"("               { return symbol("(",  LPAREN); }
")"               { return symbol(")",  RPAREN); }
"["               { return symbol("[", RBRACKET); }
"]"               { return symbol("]", LBRACKET); }

";"               { return symbol(";",  SEMI); }
"="               { return symbol("=", EQUAL); }
"<"               { return symbol("<", LESS); }  
">"               { return symbol(">", GREATER); }  
"=="              { return symbol("==", SAME); }  
"<="              { return symbol("<=", LESSEQUAL); }
">="              { return symbol(">=", GREATEREQUAL); }  
"!="              { return symbol("!=", NOTEQUAL); }  
"||"              { return symbol("||", OR); }  
">="              { return symbol(">=", GREATEREQUAL); }  
"!="              { return symbol("!=", NOTEQUAL); }  
"&&"              { return symbol("&&", AND); }
"!"               { return symbol("!",  NOT); }
","               { return symbol(",",  COMMA); } 
"."               { return symbol(".", DOT); }
"+"               { return symbol("+",  PLUS); }
"-"               { return symbol("-",  MINUS); }
"("               { return symbol("(",  LPAREN); }
")"               { return symbol(")",  RPAREN); }
"*"               { return symbol("*",  MULTIPLY); }


/* int literals */
{IntLiteral} { return symbol("Intconst", INTCONST, new Long(Long.parseLong(yytext()))); }

/*Strings*/
{Ident}           { return symbol("ident", IDENT, yytext()); }


/* comments */
"/*" [^*] ~"*/" | "/*" "*"+ "/"
                  { /* ignore comments */ }

{white_space}     { /* ignore */ }

}

/* error fallback */
[^]               { /*error("Illegal character <" + yytext() + ">");*/ Interpreter.fatalError("Illegal character <" + yytext() + ">", Interpreter.EXIT_PARSING_ERROR); }
