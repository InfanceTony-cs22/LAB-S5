%{
#include <stdio.h>
%}

%%

bool|int|float|char      { printf("Keyword\n"); }
[-+]+                    { printf("Operators\n"); }
[0-9]+                   { printf("Numbers\n"); }
[,.'"]+                  { printf("Punctuation Chars\n"); }
[&%*$@!]+                { printf("Special Characters\n"); }
[a-zA-Z_][a-zA-Z0-9_]*   { printf("Identifiers\n"); }

%%

int main() {
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}
