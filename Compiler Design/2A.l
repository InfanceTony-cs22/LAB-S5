%{
#include <stdio.h>
#include "Validarith.tab.h"
%}
%%
[a-zA-Z]+     return VARIABLE;
[0-9]+        return NUMBER;
[\t]          ; // Ignore tabs
[\n]          return 0; // End of input
.             return yytext[0];
%%
int yywrap() {
    return 1;
}

=======================================================

%{
#include <stdio.h>
#include <stdlib.h>
// Function prototype
int yylex();
void yyerror(const char *s);
%}
%token NUMBER
%token VARIABLE
%left '+' '-'
%left '*' '/' '%'
%left '(' ')'
%%
S: E {
    printf("\nEntered arithmetic expression is valid\n\n");
    return 0;
}
;
E: E '+' E
 | E '-' E
 | E '*' E
 | E '/' E
 | E '%' E
 | '(' E ')'
 | NUMBER
 | VARIABLE
;
%%
int main() {
    printf("\nEnter any arithmetic expression: \n");
    yyparse();
    return 0;
}
void yyerror(const char *s) {
    printf("\nEntered arithmetic expression is invalid: %s\n\n", s);
}
