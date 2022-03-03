package Package5;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q5
 * SymbolGraph till (input) och DirectedCycle till(output)
 */
import Package1.ST;
import Package4.Digraf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraph5 {
    private ST<String, Integer> st;// string -> index :Symboltabell där strängar är vertex namn och ints index
    private String[] keys;// index  -> string: Array inverterat index, ger vertex namn associerat med varje int -index
    private Digraf.Digraph G = null; // den underliggande grafen

    /*  Initierar en graf från en fil med den angivna avgränsaren(delimiter).
     * namnet på en vertex följt av en lista med namnen
     * filename the name of the file
     * delimiter the delimiter between fields
     */
    public SymbolGraph5(String filename, String delimiter) {
        st = new ST<String, Integer>();
        // bygger index genom att läsa strängar att associera
        Scanner in = new Scanner(filename);  // First pass
        while (in.hasNextLine()) // builds the index
        {
            String[] a = in.nextLine().split(delimiter);//läsa strings
            for (int i = 0; i < a.length; i++)//att associera var och en
            {
                if (!st.contains(a[i]))//distinct string
                    st.put(a[i], st.size());// med en index.
            }
        }

        keys = new String[st.size()]; //inverterat index för att få strängnycklar i en array
        for (String name : st.keys()) // to get string keys
        {
            keys[st.get(name)] = name; //är en array.
        }

        // andra passet bygger grafen (genom att ansluta först vertex på varje line)
        G = new Digraf.Digraph(st.size());

        in = new Scanner(filename);//andra pass

        while (in.hasNextLine()) // builds the graph
        {
            String[] a = in.nextLine().split(delimiter);//genom att ansluta
            int v = st.get(a[0]);// first vertex
            for (int i = 1; i < a.length; i++) // on each line
            {
                int w = st.get(a[i]);
                G.addEdge(v, w);// to all the others.
            }
        }
    }

    // Returnerar heltalet som är associerat med vertex named s
    //s the name of a vertex
    public int index(String s) {
        return st.get(s);
    }

    //Returns grafen som är kopplad till symbol graph.
    public Digraf.Digraph G() {
        return G;
    }

    /********************* Main *******************************************************************************************/

    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Assignment 5");
        System.out.println("******************");
        Scanner readFil = new Scanner(new File("Test4.txt")); //läsa från fil

        //Läsa alla Hörnen
        StringBuilder s = new StringBuilder();
        while (readFil.hasNextLine()) {
            s.append(readFil.nextLine());
            s.append('\n');
        }
        //min alla lista är out
        String lasaOut = s.toString();
        // Skapa en ny symbolgraf där ord separeras med "".
        SymbolGraph5 st = new SymbolGraph5(lasaOut, " ");

        Cycle5.DirectedCycle finder = new Cycle5.DirectedCycle(st.G(), " ");

        if (finder.hasCycle())
        {
            System.out.print("Directed cycle: ");
            for (int v : finder.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println();
        } else {
            System.out.println("No directed cycle");
        }
        System.out.println();
    }

}




