package Package3;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q3
 * SymbolGraph till (input) och BreadthFirstPaths (BFS) till(output)
 */
import Package1.Graph;
import Package1.LinkedStack;
import Package1.ST;
import Package2.LinkedQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraph3
{
    private ST<String, Integer> st;// string -> index :Symboltabell där strängar är vertex namn och ints index
    private String[] keys;// index  -> string: Array inverterat index, ger vertex namn associerat med varje int -index
    private Graph G; // den underliggande grafen

    /* Initierar en graf från en fil med den angivna avgränsaren(delimiter).
     * namnet på en vertex följt av en lista med namnen
     * filename the name of the file
     * delimiter the delimiter between fields
     */
    public SymbolGraph3(String filename, String delimiter) {
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

    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Assignment 3");
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
        SymbolGraph3 st = new SymbolGraph3(läsaOut, " ");

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
        BreadthFirstPaths search = new BreadthFirstPaths(st.G(), vertex1);

        System.out.println("\nDin Input: " + filename + " -> " + delimiter + ": ");
        //Om distans är 1 då är inget kant
        if (search.distTo(vertex2) == 1) {
            System.out.println("No case");
        }
             else if  (search.hasPathTo(st.index(filename)))//första Hörnen(v) input och titta på hela lista
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
    public int index(String s) {return st.get(s);}

    //Returnerar namnet på hörnet(v) som är associerat med integer v
    //v integer som motsvarar en vertex V
    //namnet på vertex som är associerat med integer v
    public String name(int v) {return keys[v];}

    //Returns grafen som är kopplad till symbol graph.
    public Graph G() {return G;}

    /************************ HÄR ÄR Breadth First Paths(BFS) ANDRA ALGORITMEN **********************************************/

    public static class BreadthFirstPaths
    {
        private boolean[] marked;  // marked[v] = is there an s-v path // OM BFS() blivit kallad för detta vertex?
        private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path // Siste vertex på känd väg till detta vertex.
        private int[] distTo;      // distTo[v] = number of edges shortest s-v path
        private final int s;         // source vertex

        //* Returns the number of edges in a shortest path between the source vertex {@code s}
        //Or source(s) and vertex (v)
        //return the number of edges in such a shortest path
        public int distTo(int v) {return distTo[v];}

        //Beräknar den kortaste vägen mellan vertex(v) och s
        //Beräknar en sökväg mellan s och varannan vertex i grafen
        //G the graph
        //s the source vertex
        public BreadthFirstPaths(Graph G, int s)
        {
            marked = new boolean[G.V()];//ger true om hörnen(v) kontaktad till s
            distTo = new int[G.V()];//ge size
            edgeTo = new int[G.V()];////size till graph
            this.s = s;//source
            bfs(G, s);////Skicka till bfs
        }

        // depth first search from v
        private void bfs(Graph G, int V)
        {
            LinkedQueue<Integer> q = new LinkedQueue<Integer>();
            marked[s] = true;// Mark the source
            q.enqueue(s);//and put it on the queue.
            distTo[s] = 0;// Antal edges mellan vertex och vertex

            while (!q.isEmpty())
            {
                int v = q.dequeue(); // Remove next vertex from the queue.
                for (int w : G.adj(v))
                    if (!marked[w]){ // For every unmarked adjacent vertex,
                        edgeTo[w] = v; // save last edge on a shortest path,
                        marked[w] = true; //mark it because path is known,
                        q.enqueue(w); //and add it to the queue.
                        distTo[w] = distTo[v] + 1;
                    }
            }
        }

        //Finns det en väg mellan vertex s och vertex v
        //v the vertex
        public boolean hasPathTo(int v) {
            return marked[v];
        }
        //Returns a shortest path between the source vertex (s) and (v)
       // public Iterable<> pathTo(int v,SymbolGraph2 G)
        public LinkedStack<Integer> pathTo(int v)
        {
            if (!hasPathTo(v)) return null;
            //Bytt till LinkedList så att utskrift av data är i den ordning jag vill.
            LinkedStack<Integer> path = new LinkedStack<Integer>();

            for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
            path.push(s);

            return path;
        }
    }
}