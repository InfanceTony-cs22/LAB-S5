 //To implement type checking
 #include<stdio.h>
 #include<stdlib.h>
 int main()
 {
 int n,i,k,flag=0;
 char vari[15],typ[15],b[15],c;
 printf("Enter the number of variables:");
 scanf(" %d",&n);
 for(i=0;i<n;i++)
 {
 printf("Enter the variable[%d]:",i);
 scanf(" %c",&vari[i]);
 printf("Enter the variable-type[%d](float-f,int-i):",i);
 scanf(" %c",&typ[i]);
 if(typ[i]=='f')
 flag=1;
 }
 printf("Enter the Expression(end with $):");
i=0;
 getchar();
 while((c=getchar())!='$')
 {
 b[i]=c
 ; i++;
 }
 k=i;
 for(i=0;i<k;i++)
 {
 if(b[i]=='/')
 {
 flag=1;
 break; } }
 for(i=0;i<n;i++)
 {
 if(b[0]==vari[i])
 {
 if(flag==1)
 {
 if(typ[i]=='f')
 { printf("\nthe datatype is correctly defined..!\n");
 break; }
 else
 { printf("Identifier %c must be a float type..!\n",vari[i]);
 break; } }
 else
 { printf("\nthe datatype is correctly defined..!\n");
 break; } }
 }
 return 0;
 }


==========================================================================

%{
#include <stdio.h>
#include <stdlib.h>
int yylex(void); // Declaration of yylex
void yyerror(const char *s);

// Structure to hold three-address code information
struct expr {
    char operand1;
    char operand2;
    char operator;
    char result;
};

// Function prototypes
char addtotable(char a, char b, char o);
void threeAdd();

// Global variables
struct expr arr[20];
int index1 = 0;
char temp = 'A' - 1; // Temporary variable counter
%}

%union {
    char symbol; // Symbol type to hold characters
}

%token <symbol> LETTER NUMBER
%type <symbol> exp
%left '+' '-'
%left '*' '/'

%%
statement:
    LETTER '=' exp ';' { addtotable($1, $3, '='); }
;

exp:
    exp '+' exp { $$ = addtotable($1, $3, '+'); }
    | exp '-' exp { $$ = addtotable($1, $3, '-'); }
    | exp '*' exp { $$ = addtotable($1, $3, '*'); }
    | exp '/' exp { $$ = addtotable($1, $3, '/'); }
    | '(' exp ')' { $$ = $2; }
    | NUMBER { $$ = $1; }
    | LETTER { $$ = $1; }
;

%%
void yyerror(const char *s) {
    fprintf(stderr, "Error: %s\n", s);
}

char addtotable(char a, char b, char o) {
    temp++;
    arr[index1].operand1 = a;
    arr[index1].operand2 = b;
    arr[index1].operator = o;
    arr[index1].result = temp;
    index1++;
    return temp;
}

void threeAdd() {
    for (int i = 0; i < index1; i++) {
        printf("%c := %c %c %c\n", arr[i].result, arr[i].operand1, arr[i].operator, arr[i].operand2);
    }
}

int main() {
    printf("Enter the expression: ");
    yyparse();
    threeAdd();
    return 0;
}
