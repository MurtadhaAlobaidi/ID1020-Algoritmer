import java.util.Scanner;

class fIFOqueue3
{
    public static void main(String[] args)
    {
        // för definierat standard inmatningsobjekt
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Input:");
        // ändra skanner avgränsaren så s.next ger enstaka tecken istället för ord
        // Ändra avgränsaren för denna skanner
        s.useDelimiter("");
        // För att fylla på stacken
        queue<Item> stack = new queue<Item>();
        //roppa upp Stack
        //new Stack();
    }
}
/*
        // loop för att läsa in, boksäver för bokstäver
        while (true)
        {
            //Det är en skannerklassmetod som returnerar sant om den här skannern.
            if (s.hasNext()) {
                //Läsa char
                char c = s.next().charAt(0);
                //Stopa läsning if nytt char LF
                if (c == '\n')
                    break;
                else
                    //addera nytt char till stack
                    cs.push(c);
            }
        }

        System.out.println("Your Input:");

        //tömma stack och skriv ut den
        while (!cs.tom())
        {
            System.out.print(cs.pop());
        }
        System.out.println();
    }
