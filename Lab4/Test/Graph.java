package Test;

import java.util.Scanner;

public class Graph
{
    private final int V; //nummer av Hörnen (V)
    private int E; //nummer av Kanten (E)
    private Bag<Integer>[] adj; //Array ut av referens Bag som innehåller hel tal (linked list)

    /* Starata toma graf med sin hörnen V
    * Skapa ett graf med att anropa antal hörn (V)
     */
    public Graph(int V)
    {
        Scanner in = new Scanner(System.in);
        //if (V < 0) throw new IllegalArgumentException("Number of vertices must be non-negative");
        this.V = V;//Satt upp antalet hörnen (V)
        this.E = 0;//Satt upp Kant (E)
        adj = (Bag<Integer>[]) new Bag[V]; //Skapa nytt array som innehåller mycket index i (vi har hörn V) //
        // Varje plats i den array har en referens till en Bag som kan innehåller hel tal
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    // Läsa in från filen som inhåller kant(E) och hörnen(V)
    public Graph(Scanner in)
    {
       // if (in == null) throw new IllegalArgumentException("argument is null");
       // try {
           this.V = in.nextInt(); //Läsa hörnen V och bygga graf V
           // if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be non-negative");
          //  adj = (Bag<Integer>[]) new Bag[V];

          //  for (int v = 0; v < V; v++) {
               // adj[v] = new Bag<Integer>();
           // }
            int E = in.nextInt(); //Läsa kanten E
          //  if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be non-negative");
            //för att adera en kant
            for (int i = 0; i < E; i++)
            {
                int v = in.nextInt();//för att läsa startHörnen(v)
                int w = in.nextInt();//för att läsa endHörnen(d)
               // validateVertex(v);
               // validateVertex(w);
                addEdge(v, w); //Addera de kanten som är ihop
            }
        }

        //catch (NoSuchElementException e) {
        //    throw new IllegalArgumentException("invalid input format in Graph constructor", e);
      //  }



    //Hur mycket vertices(hörnen) (V) vi har och Returnera nummer of Vertices (hörnen)
    public int V() {return V;}

    //Hur mycket Edge(Kanten) (E) Returnera nummer of Edge(Kanten)
    public int E() {return E;}

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    //v startHörnen och V är graf
/*    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }*/

    //För att lägga till ett edge(kant)(E) som går mellan två vertices (hörnen) (hörnen v och w)
    public void addEdge(int v, int w)
    {
      //  validateVertex(v);
      //  validateVertex(w);
        E++; //så den fylla lista med kant(E)
        adj[v].add(w);//från hörnen (v) vi kan nå hörnen (w) och lägg den i Bag
        adj[w].add(v);//från hörnen (w) vi kan nå hörnen (v) och lägg den i Bag (icke riktat graf)
    }

    /*
    *Hur mycket kant(Edge) (E) kan leda INNE och UTE från en hörn(vertices) (v)
    * startHörn (v) slutHörn(w)
     */
/*
    public int degree(Graph G int v) {
        int degree=0;
        for (int w : G.adj(v))
            degree++;
        validateVertex(v);
        return degree;
    }*/

    /* För att få fram ett Objekt som vi kan Iterera över som innehåller alla hörnen (v,w) som har direkt
     * bindning så vi kan nå vid en kant(E) från en vis strata hörn(v)
     */
    public Iterable<Integer> adj(int v) {
       // validateVertex(v);
        return adj[v];
    }


    /*För att return String för Grafen
    *return nummer av hörnen(V) med nummer av kanten (E) följade med listan V
     */
    public String toString()
    {
       // StringBuilder s = new StringBuilder();
        String s =(V + " vertices, " + E + " edges ");

        for (int v = 0; v < V; v++)
        {
            s += v + ": ";
            for (int w : adj[v])
            {
                s +=w + " ";

            }
        }
        return s;
    }
}
