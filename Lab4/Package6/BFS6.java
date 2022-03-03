package Package6;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q6
 * BreadthFirstDirectedPaths (BFS) till(output)  kapitel 4
 */
import Package1.LinkedStack;
import Package2.LinkedQueue;

public class BFS6
{
    public static class BreadthFirstDirectedPaths {
        private boolean[] marked;  // marked[v] = is there an s->v path?
        private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
        private int[] distTo;      // distTo[v] = length of shortest s->v path

        /**
         * Computes the shortest path from {@code s} and every other vertex in graph {@code G}.
         * @param G the digraph
         * @param s the source vertex
         */
        public BreadthFirstDirectedPaths(Digraph6.Digraph G, int s) {
            marked = new boolean[G.V()];
            distTo = new int[G.V()];
            edgeTo = new int[G.V()];
            for (int v = 0; v < G.V(); v++)
            bfs(G, s);
        }

        // BFS from single source
        private void bfs(Digraph6.Digraph G, int s) {
            LinkedQueue<Integer> q = new LinkedQueue<>();
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
            while (!q.isEmpty()) {
                int v = q.dequeue();
                for (int w : G.adj(v)) {
                    if (!marked[w]) {
                        edgeTo[w] = v;
                        distTo[w] = distTo[v] + 1;
                        marked[w] = true;
                        q.enqueue(w);
                    }
                }
            }
        }

        /**
         * Is there a directed path from the source {@code s} (or sources) to vertex {@code v}?
         * @param v the vertex
         * @return {@code true} if there is a directed path, {@code false} otherwise
         */
        public boolean hasPathTo(int v) {
            return marked[v];
        }

        /**
         * Returns the number of edges in a shortest path from the source {@code s}
         * (or sources) to vertex {@code v}?
         * @param v the vertex
         * @return the number of edges in such a shortest path
         */
        public int distTo(int v) {
            return distTo[v];
        }

        /**
         * Returns a shortest path from {@code s} (or sources) to {@code v}, or
         * {@code null} if no such path.
         * @param v the vertex
         * @return the sequence of vertices on a shortest path, as an Iterable
         */
        public Iterable<Integer> pathTo(int v) {

            if (!hasPathTo(v)) return null;
            LinkedStack<Integer> path = new LinkedStack<>();
            int x;
            for (x = v; distTo[x] != 0; x = edgeTo[x])
                path.push(x);
            path.push(x);
            return path;
        }
    }
}

