package Package1;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q1
 *Graph används i SymbolGraph (from kapitel 4 GRAPHS)
 */
import java.util.Scanner;
public class Graph
{
    private final int V;//nummer av Hörnen (V)
    private int E;//nummer av Kanten (E)
    private Bag<Integer>[] adj;//linked list ut av referens Bag som innehåller hel tal

    /* Starata toma graf med sin hörnen V
     * Skapa ett graf med att anropa antal hörn (V)
     */
    public Graph(int V)
    {
        this.V = V;//Satt upp antalet hörnen (V)
        this.E = 0;//Satt upp Kant (E)
        //Skapa nytt array som innehåller index ( hörn V)
        // Varje plats i den array har en referens till en Bag som kan innehåller hel tal
        adj = (Bag<Integer>[]) new Bag[V];
        //Gå genom alla lista
        for (int v = 0; v < V; v++)
        {
            adj[v] = new Bag<Integer>();//tom bag
        }
    }

    /* Hur mycket vertices(hörnen) (V)
    *  vi har och Returnera nummer of Vertices (hörnen)
    */
    public int V() {return V;}

    /* För att lägga till ett edge(kant)(E)
    *  som går mellan två vertices (hörnen) (hörnen v och w)
    */
    public void addEdge(int v, int w)
    {

        //från hörnen (v) vi kan nå hörnen (w) och lägg den i Bag
        adj[v].add(w);
        //från hörnen (w) vi kan nå hörnen (v) och lägg den i Bag (icke riktat graf)
        adj[w].add(v);
        E++;
    }

    /* För att få fram ett Objekt som vi kan Iterera över som innehåller alla hörnen (v,w) som har direkt
     * bindning så vi kan nå vid en kant(E) från en vis strata hörn(v)
     */
    public Iterable<Integer> adj(int v) {return adj[v];}
}
