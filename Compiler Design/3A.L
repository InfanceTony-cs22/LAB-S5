%{
#include "wh.tab.h"
%}
%option noyywrap
%%
"while"        { return WHILE; }
"("            { return LPAREN; }
")"            { return RPAREN; }
"{"            { return LBRACE; }
"}"            { return RBRACE; }
"="            { return ASSIGN; }
"<"            { return LT; }
">"            { return GT; }
"=="           { return EQ; }
"+"            { return PLUS; }
"-"            { return MINUS; }
"*"            { return MULT; }
"/"            { return DIV; }
";"            { return SEMICOLON; }
[0-9]+         { yylval = atoi(yytext); return NUMBER; }
[a-zA-Z][a-zA-Z0-9]* { return IDENTIFIER; }
[ \t\n]+       { /* skip whitespace */ }
.              { printf("Unexpected character: %s\n", yytext); return yytext[0]; }
<<EOF>>        { return 0; }


=================================================================================================


%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void yyerror(const char *s);
int yylex(void);
%}
%token WHILE LPAREN RPAREN LBRACE RBRACE SEMICOLON IDENTIFIER NUMBER
%token ASSIGN LT GT EQ PLUS MINUS MULT DIV
%left PLUS MINUS
%left MULT DIV
%left LT GT EQ
%right ASSIGN
%%
program:
    statement
;

statement:
    WHILE LPAREN condition RPAREN LBRACE statements RBRACE
    {
        printf("Valid 'while' loop recognized.\n");
    }
;

statements:
    statement
    | assignment SEMICOLON
    | statements statement
    | /* empty */
;

assignment:
    IDENTIFIER ASSIGN expression
;

condition:
    expression LT expression
    | expression GT expression
    | expression EQ expression
;

expression:
    IDENTIFIER
    | NUMBER
    | expression PLUS expression
    | expression MINUS expression
    | expression MULT expression
    | expression DIV expression
;
%%
void yyerror(const char *s) {
    fprintf(stderr, "Error: %s\n", s);
}

int main(void) {
    printf("Enter a 'while' loop to check:\n");
    yyparse();
    return 0;
}
