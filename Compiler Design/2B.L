%{
#include "valid_identifier.tab.h"
%}
%%
[a-zA-Z][a-zA-Z0-9]*    { return IDENTIFIER; }
.                       { return 0; } /* For any other invalid characters */
%%
int yywrap() {
    return 1;
}


===============================================================================================


%{
#include <stdio.h>
#include <ctype.h>

// Declaration of yylex function
int yylex(void);

// Declaration of yyerror function
int yyerror(const char *s);
%}
%token IDENTIFIER
%%
start:
    identifier_check
;

identifier_check:
    IDENTIFIER { printf("It is a valid identifier!\n"); }
    | /* error handling for invalid input */
    { printf("It is not a valid identifier!\n"); }
;
%%
int yyerror(const char *s) {
    printf("Error: %s\n", s);
    return 0;
}

int main() {
    printf("Enter a name to be tested for identifier: ");
    yyparse();
    return 0;
}
