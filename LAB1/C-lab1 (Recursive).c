#include <stdio.h>
#include <stdlib.h>
void Writtning(void)
{
    char m ;//listas namn
    if ((m=getchar()) == '\n') //att matta in i listen
    {
    return;
    }
        else {
        Writtning();//roppa upp functionen
        printf( "%c",m );
              }
    return;
}
  
int main(void)
{
    Writtning(); //roppa upp functionen igen
    putchar('\n');
    return 0;
}


