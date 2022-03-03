package Assignment6;
import package6.MedianOfThree;
import java.util.Random;
import java.util.Scanner;
import static package4.Quick.sortQ;
import static package6.MedianOfThree.sortMedian;

public class Sort6 {
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
        System.out.print("Lab 2 Assignment 6: "); //Skriva ut ämnas för Assignment 2
        System.out.println("\n-----------------------\n");
        System.out.println("Skriv storlek på listan: ");

        final Random random = new Random(); //För att fylla på Arry
        Scanner s = new Scanner(System.in); //Ta emot Input
        int b = s.nextInt();
        int [] x  = new int[b];//Input Insertion
        int [] a  = new int[b];//Input Insertion

        for(int i = 0; i<b; i++) {
            a[i] = random.nextInt(1000);
            x[i] = a[i];
        }

        System.out.println("\n ");
        sortMedian(a);

        //Median-of-three partitioning
        startwatch();//Start Time för Insertion
        MedianOfThree.sortMedian(a);
        elapsedTime(); //stopp Time excution

        //Quicksort
        startwatch();//Start Time för Insertion
        sortQ(a);
        elapsedTime(); //stopp Time excution

        System.out.println("\n********************\n");
    }

}
