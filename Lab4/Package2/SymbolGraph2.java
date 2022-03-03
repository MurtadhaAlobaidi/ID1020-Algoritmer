package Package2;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q2
 * SymbolGraph till (input) och BreadthFirstPaths (BFS) till(output)
 */
import Package1.Graph;
import Package1.ST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraph2 {
    private ST<String, Integer> st;// string -> index :Symboltabell där strängar är vertex namn och ints index
    private String[] keys;// index  -> string: Array inverterat index, ger vertex namn associerat med varje int -index
    private Graph G; // den underliggande grafen

    /*
     * Initierar en graf från en fil med den angivna avgränsaren(delimiter).
     * namnet på en vertex följt av en lista med namnen
     * filename the name of the file
     * delimiter the delimiter between fields
     */
    public SymbolGraph2(String filename, String delimiter) {
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
        G = new Graph(st.size());

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

    /********************* Main *******************************************************************************************/

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Assignment 2");
        System.out.println("******************");
        Scanner readFil = new Scanner(new File("Test4.txt")); //läsa från fil

        //Läsa alla Hörnen
        StringBuilder s = new StringBuilder();
        while (readFil.hasNextLine()) {
            s.append(readFil.nextLine());
            s.append('\n');
        }
        //min alla lista är out
        String läsaOut = s.toString();
        // Skapa en ny symbolgraf där ord separeras med "".
        SymbolGraph2 st = new SymbolGraph2(läsaOut, " ");

        //Ta emot hörnen 1 Input
        System.out.println("Första Hörnen: ");
        Scanner first = new Scanner(System.in);//Input scanner
        String startHornen = first.nextLine();//Scanner till String
        int vertex1 = st.index(startHornen);//String till index

        //Ta emot hörnen 2 Input
        System.out.println("Andra Hörnen: ");
        Scanner end = new Scanner(System.in);//Input scanner
        String endHornen = end.nextLine();//Scanner till String
        int vertex2 = st.index(endHornen);//String till index

        String filename = startHornen;// First state
        String delimiter = endHornen;// End state.

        //Create a BFS object
        BFS.BreadthFirstPaths search = new BFS.BreadthFirstPaths(st.G(), vertex1);

        System.out.println("\nDin Input: " + filename + " -> " + delimiter + ": ");


        if (search.hasPathTo(st.index(filename)))//första Hörnen(v) input och titta på hela lista
        {
            System.out.println("\nDin kant: ");

            for (int i : search.pathTo(st.index(delimiter)))//andra Hörnen(v) och titta om det finns koppling
            {

                if (st.name(i).equals(filename))//om det finns din hörnen
                    System.out.print(st.name(i));//skriv ut den hörnen

                 else
                    System.out.print(" - " + st.name(i) + " ");
            }
            System.out.println();
        }
    }

    // Returnerar heltalet som är associerat med vertex named s
    //s the name of a vertex
    public int index(String s) {
        return st.get(s);
    }

    //Returnerar namnet på hörnet(v) som är associerat med integer v
    //v integer som motsvarar en vertex V
    //namnet på vertex som är associerat med integer v
    public String name(int v) {
        return keys[v];
    }

    //Returns grafen som är kopplad till symbol graph.
    public Graph G() {
        return G;
    }
}