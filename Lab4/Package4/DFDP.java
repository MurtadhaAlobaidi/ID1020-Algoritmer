package Package4;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q2
 * DepthFirstDirectedPaths (DFS) till(output)  kapitel 4
 */
import Package1.LinkedStack;

public class DFDP {
    public static class DepthFirstDirectedPaths {
        private boolean[] marked;  // marked[v] = true iff v is reachable from s
        private int[] edgeTo;      // edgeTo[v] = last edge on path from s to v
        private final int s;       // source vertex

        //Beräknar den kortaste vägen mellan vertex(v) och s
        //Beräknar en sökväg mellan s och varannan vertex i grafen
        //G the graph
        //s the source vertex
        public DepthFirstDirectedPaths(Digraf.Digraph G, int s) {
            marked = new boolean[G.V()];//ger true om hörnen(v) kontaktad till s
            edgeTo = new int[G.V()];//ge size
            this.s = s;//size till graph
            dfs(G, s);//Skicka till bfs
        }

        // depth first search from v
        private void dfs(Digraf.Digraph G, int v) {
            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(G, w);
                }
            }
        }

        //hasPathTo den kolla om det finns väg mellan v och sours
        public boolean hasPathTo(int v) {
            return marked[v];
        }

        //Den hjälper för att kan nå hela lista av hela listan av grafen
        public Iterable<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            //Bytt till LinkedList så att utskrift av data är i den ordning jag vill.
            //Returnera till path som innehåller stack
            LinkedStack<Integer> path = new LinkedStack<>();
            //om hörnen !=sours då addera till hörnen (v)
            for (int x = v; x != s; x = edgeTo[x])
            path.push(x);//skicka hörnen(v) till stack
            path.push(s);//skicka hörnen(s) till stack
            return path;
        }
    }
}
