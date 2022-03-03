package Package6;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q6
 * Main BreadthFirstDirectedPaths (BFS) till(output) och Digraph  kapitel 4
 */
import Package1.Bag;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Digraph6
{
    public static class Digraph
    {
        private static int V;// number of vertices in this digraph
        private static int E;// number of edges in this digraph
        private static Bag<Integer>[] adj;// adj[v] = adjacency list for vertex v

      /*
         * Initializes an empty digraph with <em>V</em> vertices.
         */
        public Digraph(int V) {
            if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be non-negative");
            this.V = V;
            this.E = 0;
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
        }

        /**
         * Initializes a digraph from the specified input stream.
         * The format is the number of vertices <em>V</em>,
         * followed by the number of edges <em>E</em>,
         * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
         */
        public Digraph(Scanner in) {
                this.V = in.nextInt();
                adj = (Bag<Integer>[]) new Bag[V];
                for (int v = 0; v < V; v++) {
                    adj[v] = new Bag<Integer>();
                }
                int E = in.nextInt();
                for (int i = 0; i < E; i++) {
                    int v = in.nextInt();
                    int w = in.nextInt();
                    in.nextInt();
                    addEdge(v, w);
                }
            }

        /**
         * Returns the number of vertices in this digraph.
         */
        public int V() {
            return V;
        }

        /**
         * Adds the directed edge v→w to this digraph.
         * @param v the tail vertex
         */
        public static void addEdge(int v, int w) {
            adj[v].add(w);
            E++;
        }

        /**
         * Returns the vertices adjacent from vertex {@code v} in this digraph.
         * @param v the vertex
         */
        public Iterable<Integer> adj(int v) {
            return adj[v];
        }

    }
        //**************************************************************************************************************/
        public static void main(String[] args) throws FileNotFoundException {
            System.out.println("Assignment 6");
            System.out.println("******************");
            Scanner readFil = new Scanner(new File("NYC.txt")); //läsa från fil

            Digraph G = new Digraph(readFil);

            System.out.println("Enter A: ");
            Scanner first = new Scanner(System.in);//Input scanner
            int s = first.nextInt();//Start station

            //BFS objekt G,s
            BFS6.BreadthFirstDirectedPaths bfs = new BFS6.BreadthFirstDirectedPaths(G, s);

            System.out.println("Enter B: ");
            Scanner andra = new Scanner(System.in);//Input scanner
            int v = andra.nextInt();//Slut station

            System.out.println("Enter C: ");
            Scanner through = new Scanner(System.in);//Input scanner
            int r = through.nextInt();//Through station

            //BFS objekt G,r
            BFS6.BreadthFirstDirectedPaths bfs1 = new BFS6.BreadthFirstDirectedPaths(G, r);

            System.out.printf("%d through %d to %d (%d):  ", s, r, v, (bfs.distTo(r) + bfs1.distTo(v)));
            for (int x : bfs.pathTo(r)) //den kolla s om det finns pathTo med hörnen(r) och kolla alla hörnen
            {
                if (x == s) System.out.print(x);//Om du hitta en pathTo mellan hörnen skriva ut den
                else System.out.print("->" + x);
            }

            for (int t : bfs1.pathTo(v))//den kolla r om det finns pathTo med hörnen(v) och kolla alla hörnen
            {
                if (t == r) ;//Om du hitta en pathTo mellan hörnen skriva ut den
                else System.out.print("->" + t);//t är variabel som ta information from pathTo och spara den
            }
            System.out.println();
        }
}