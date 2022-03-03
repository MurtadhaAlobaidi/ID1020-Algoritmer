package Stack2;
public class stack
{
    //bygga nytt char
    private char[] char1;
    //längden för den nya char
    private int length;

    //Class för att nytt char ska ha obgränsade längd
    public stack()
    {
        //den nya cahr
        char1 = new char['\n'];
        //börjar från första index
        length = 0;
    }
    //push maethod för att push element till Stacken
    public void push(char c)
    {
        //Om längden stora än min nya char
        if (length >= char1.length)
            //gör listan stora so den ta mer plats
            storlista();
        //Den nya list sparat i stacken
        char1[length] = c;
        //addera till längden
        length++;
    }
    //pop method för att tabort de elementar som finns i stacken
    public char pop()
    {
       char c =char1[length]; //spara liste för return
       char1[length]=0;  //ta bort den forst i staken

        //Ta bort från stacken
        length--;
        //Gå tillbaka till nya char data typen som inhåller min nya lista
        return char1[length];
    }

    //kopia listan till stora listan
    private void storlista()
    {
        //Att skappa nytt stora lista för att få mer plats
        char[] char2 = new char[char1.length * 2];
        //För att fylla på den nya liste
        for (int i = 0; i < char1.length; i++)
            //Min nya lista
            char2[i] = char1[i];
        //För att lämna tillbaka till den orginal listan
        char1 = char2;
    }
    //För att kontrollera om kön är tom eller inte.(true eller false)
    public boolean tom()
    {
        //tomma längden och gå tillbaka till den
        return length == 0;
    }

}
