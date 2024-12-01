#include <stdio.h>
#include <string.h>

void main() {
    char icode[10][30], str[20], opr[10];
    int i = 0;

    printf("\nEnter the set of intermediate code (terminated by 'exit'):\n");
    do {
        scanf("%s", icode[i]);
    } while (strcmp(icode[i++], "exit") != 0);

    printf("\nTarget Code Generation");
    printf("\n************************");

    i = 0;
    do {
        strcpy(str, icode[i]);
        // Determine the operator
        switch (str[3]) {
            case '+':
                strcpy(opr, "ADD");
                break;
            case '-':
                strcpy(opr, "SUB");
                break;
            case '*':
                strcpy(opr, "MUL");
                break;
            case '/':
                strcpy(opr, "DIV");
                break;
            default:
                strcpy(opr, "UNKNOWN");
                break;
        }

        // Generate target code
        printf("\n\tMov %c, R%d", str[2], i);        // Move operand to register
        printf("\n\t%s %c, R%d", opr, str[4], i);   // Perform the operation
        printf("\n\tMov R%d, %c", i, str[0]);       // Move result to target
    } while (strcmp(icode[++i], "exit") != 0);

    return;
}
