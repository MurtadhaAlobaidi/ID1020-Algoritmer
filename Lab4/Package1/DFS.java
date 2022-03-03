package Package1;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q1
 * DepthFirstPaths (DFS) till(output) kapitel 4
 */
public class DFS
{
    public static class DepthFirstPaths
    {
        private final int s;         // source vertex
        public boolean[] marked; // OM DFS() blivit kallad för detta vertex eller EJ?
        private final int[] edgeTo; // Siste vertex på känd väg till detta vertex(om den kopplade eller EJ(v-s)).

        //Beräknar en sökväg mellan s och varannan vertex i grafen
        //G the graph
        //s the source vertex
        public DepthFirstPaths(Graph G, int s)
        {
            this.s = s;//s är source
            marked = new boolean[G.V()];//ger true om hörnen(v) kontaktad till s och skapa (arry samma längd som G.V)
            edgeTo = new int[G.V()];//size till graph
            dfs(G, s);//Skicka till dfs (hörnen och sours)
        }

        // depth first search from v
        private void dfs(Graph G, int v)
        {
            marked[v] = true; ////ger true då hörnen besökt
            for (int w : G.adj(v))//så den gå genom hela (linked list) av referens Bag som innehåller alla vertex som kontaktad till v
                if (!marked[w]) {//om hörnen(w) inte kontaktad
                    edgeTo[w] = v;//add till hörn(w) som kontaktad till (v) (rita vägen)
                    dfs(G, w);////Skicka till dfs (hörnen och sours (w))
                }
        }

        //hasPathTo den kolla om det finns väg mellan v och sours
        public boolean hasPathTo(int v) {
            return marked[v];
        }

        //Den hjälper för att kan nå hela lista av hela listan av grafen
        public Iterable<Integer> pathTo(int v, Graph g) {
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
