package Package2;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q2
 * BreadthFirstPaths (BFS) till(output)  kapitel 4
 */
import Package1.Graph;
import Package1.LinkedStack;

public class BFS
{
    public static class BreadthFirstPaths
    {
        private final int s;         // source vertex
        private boolean[] marked;  // marked[v] = is there an s-v path //OM BFS() blivit kallad för detta vertex?
        private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
        private int[] distTo;      // distTo[v] = number of edges shortest s-v path //Siste vertex på känd väg till detta vertex.

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
        private void bfs(Graph G, int V) {
            LinkedQueue<Integer> q = new LinkedQueue<Integer>();
            marked[s] = true;// Mark the source
            q.enqueue(s);//and put it on the queue.
            distTo[s] = 0;// Antal edges mellan vertex och vertex
            while (!q.isEmpty())
            {
                int v = q.dequeue(); // Remove next vertex from the queue.
                for (int w : G.adj(v))
                    if (!marked[w])
                    { // For every unmarked adjacent vertex,
                        edgeTo[w] = v; // save last edge on a shortest path,
                        marked[w] = true; //mark it because path is known,
                        q.enqueue(w); //and add it to the queue.
                        distTo[w] = distTo[v] + 1;//addaer 1 vaje gång finns nytt kant(edges)
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
            path.push(x);//skicka hörnen(v) till stack
            path.push(s);//skicka hörnen(s) till stack
            return path;
        }
    }
}

