/*
package Test3;
import Package1.DFS;
import Package3.BFS3;
import Package3.DFS3;
import Package3.SymbolGraph3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File D = new File("Test4.txt");
        SymbolGraph3 G = new SymbolGraph3(D, "\\s");


        Scanner user_in = new Scanner(System.in);

        System.out.println("\n enter a source vertx : ");
        String source = user_in.nextLine();
        int v1 = G.indexOf(source);
        System.out.println("\n enter a destination vertx : ");
        String des = user_in.nextLine();
        int v2 = G.indexOf(des);

        DFS3.DepthFirstPaths x = new DFS3.DepthFirstPaths(G,v1);
        //System.out.println(x.hasPathTo(v2,G().G));
        //System.out.println(x.hasPathTo(v2,G().G));

        BFS3.BreadthFirstPaths n = new BFS3.BreadthFirstPaths(v1);
        System.out.println(n.hasPathTo(v2));
        System.out.println(n.pathTo(v2));
    }
}
*/
