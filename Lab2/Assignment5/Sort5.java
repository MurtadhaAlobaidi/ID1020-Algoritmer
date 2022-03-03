package Assignment5;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import static package5.MergeX.sortX;

public class Sort5 {
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
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Lab 2 Assignment 5: "); //Skriva ut ämnas för Assignment 4
        System.out.println("\n-----------------------\n");
        System.out.println("Skriv storlek på listan: ");
        final Random random = new Random(); //För att fylla på Arry
        Scanner s = new Scanner(System.in); //Ta emot Input
        int b = s.nextInt();

        int [] a  = new int[b];//Input Insertion
        for(int i = 0; i<b; i++)
            a[i]=random.nextInt(1000);

        startwatch();//Start Time för Insertion
        //sortI(a);
        sortX(a);
        elapsedTime(); //stopp Time excution
        //System.out.println("Insertion");
    }
}
