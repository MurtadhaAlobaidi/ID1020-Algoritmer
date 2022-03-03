package Package4;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q4
 *Digraph (from kapitel 4 GRAPHS)
 */
import Package1.Bag;

public class Digraf {
    public static class Digraph
    {
        private static int V;// number of vertices in this digraph
        private static int E;// number of edges in this digraph
        private static Bag<Integer>[] adj;// adj[v] = adjacency list for vertex v

        /* Starata toma graf med sin hörnen V
         * Skapa ett graf med att anropa antal hörn (V)
         */
        public Digraph(int V)
        {
            this.V = V;
            this.E = 0;
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
        }

        /* Hur mycket vertices(hörnen) (V)
         *  vi har och Returnera nummer of Vertices (hörnen)
         */
        public int V() {
            return V;
        }

        /**
         * Adds the directed edge v→w to this digraph.
         * @param  v the tail vertex
         * @param  w the head vertex
         */
        public static void addEdge(int v, int w)
        {
            adj[v].add(w);//från v till w bara
            E++;
        }

        /* För att få fram ett Objekt som vi kan Iterera över som innehåller alla hörnen (v,w) som har direkt
         * bindning så vi kan nå vid en kant(E) från en vis strata hörn(v)
         */
        public Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }
}
