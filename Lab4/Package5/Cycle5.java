package Package5;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q5
 * DirectedCycle till(output) kapitel 5
 */
import Package1.LinkedStack;
import Package4.Digraf;

public class Cycle5
{
    public static class DirectedCycle {
        private boolean[] marked;        // marked[v] = has vertex v been marked?
        private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
        private boolean[] onStack;       // onStack[v] = is vertex on the stack?
        private LinkedStack<Integer> cycle;    // directed cycle (or null if no such cycle)

        /**
         * Determines whether the digraph {@code G} has a directed cycle and, if so,
         * finds such a cycle.
         * @param G the digraph
         * @param vertex1
         */
        public DirectedCycle(Digraf.Digraph G, String vertex1) {
            marked  = new boolean[G.V()];
            onStack = new boolean[G.V()];
            edgeTo  = new int[G.V()];
            for (int v = 0; v < G.V(); v++)
                if (!marked[v] && cycle == null)
                    dfs(G, v);
        }

        // run DFS and find a directed cycle (if one exists)
        private void dfs(Digraf.Digraph G, int v) {
            onStack[v] = true;//besökt
            marked[v] = true;//
            for (int w : G.adj(v)) {
                // short circuit if directed cycle found
                if (cycle != null) return;
                    // found new vertex, so recur
                else if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(G, w);
                }

                // trace back directed cycle
                else if (onStack[w]) {
                    cycle = new LinkedStack<>();
                    for (int x = v; x != w; x = edgeTo[x]) {
                        cycle.push(x);
                    }
                    cycle.push(w);
                    cycle.push(v);
                }
            }
            onStack[v] = false;
        }

        /**
         * Does the digraph have a directed cycle?
         */
        public boolean hasCycle() {
            return cycle != null;
        }

        /**
         * Returns a directed cycle if the digraph has a directed cycle, and {@code null} otherwise.
         * @return a directed cycle (as an iterable) if the digraph has a directed cycle,
         */
        public Iterable<Integer> cycle() {
            return cycle;
        }
    }
}
