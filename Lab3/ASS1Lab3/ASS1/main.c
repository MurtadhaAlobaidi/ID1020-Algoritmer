//  main.c
//  Lab3
//  Created by murtadha alobaidi on 2021-09-29.
#include <stdio.h>
#include <ctype.h>
int main()
{
    FILE *aRead;//Skapa ett pointer för att läsa filen
    FILE *aWrit;//Skappa ett pointer för att skriva i den
    char ch;//char varibel
    aRead=fopen("/Users/murtadha/Desktop/Fil98.txt", "r");//Läsa från filen
    aWrit=fopen("/Users/murtadha/Desktop/Fil99Svar.txt", "w");//Skriva till filen
    
    //För att gå genom hela texten
    while ((ch=fgetc(aRead)) !=EOF)
    {
        //to remove all characters that are not alphabetic, blank or newline - replacing every such character by a blank
        if (! isalpha(ch) == 0 ||ch ==' ' || ch =='\n')
        {
            fprintf(aWrit, "%c",ch );
        }else
            {
            fprintf(aWrit, " ");
            }
    }
    fclose(aWrit);
    fclose(aRead);
    return 0;
}
