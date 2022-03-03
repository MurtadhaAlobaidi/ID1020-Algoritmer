package Assignment4;
import java.util.Random;
import java.util.Scanner;
import static package4.Insertion.sortI;
import static package4.Merge.sortM;
import static package4.Quick.sortQ;

public class Sort4 {

    //Mathod för starta Time complexity
    private static long start;
    public static void startwatch()
    {
        start = System.currentTimeMillis();
    }
    //Mathod för stopp Time complexity
    public static void elapsedTime()
    {
        long now = System.currentTimeMillis();
       // System.out.println("\n");
        System.out.println("\nTime excution : "+(now - start)/ 1000.0);
    }

    //För att testa main funktion
    public static void main(String[] args)
    {
        System.out.print("Lab 2 Assignment 4: "); //Skriva ut ämnas för Assignment 4
        System.out.println("\n-----------------------\n");
        System.out.println("Skriv storlek på listan: ");
        final Random random = new Random(); //För att fylla på Arry
        Scanner s = new Scanner(System.in); //Ta emot Input
        int b = s.nextInt();


       /* int [] a  = new int[b];//Input Insertion
        for(int i = 0; i<b; i++)
            a[i]=random.nextInt(1000);

        int [] g  = new int[b]; //Input Merge
        for(int i = 0; i<b; i++)
            g[i]=random.nextInt(1000);*/

        int [] h  = {2,5,8,1,7,4,3,6};//Input Quick
        for(int i = 0; i<b; i++)
            System.out.print(h[i]+ " ");
             System.out.println();
         //   h[i]=random.nextInt(1000);

        sortQ(h);
/*
        startwatch();//Start Time för Insertion
        sortI(a);
        elapsedTime(); //stopp Time excution
        System.out.println("Insertion");


        startwatch();//Start Time för Quick
        sortQ(h);
        elapsedTime(); //stopp Time excution
        System.out.println("Quick");

        startwatch();//Start Time för Merge
        sortM(g);
        elapsedTime(); //stopp Time excution
        System.out.println("Merge:"); */
    }
}