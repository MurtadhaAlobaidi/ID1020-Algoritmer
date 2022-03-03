package Assignment7;
import java.util.Scanner;
import static package7.Insertinonsort7.sortIA7;

public class Sort7 {
    //För att testa main funktion
    public static void main(String[] args)
    {
        System.out.print("Lab 2 Assignment 1: "); //Skriva ut ämnas för Assignment 1
        System.out.println("\n-----------------------\n");
        System.out.println("Skriv storlek på listan: ");
        Scanner s = new Scanner(System.in); //Ta emot Input
        int [] a  = new int[s.nextInt()]; //Input

        //För att säga till vilken index du mata in
        for (int i = 0; i < a.length; i++) {
            //System.out.println("Skriva "+i+ " element till listan:");
            a[i]=s.nextInt(); //nya listen
        }
        //För att skriva ut hela input listen utan sotering
        System.out.print("Din Input: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" +a[i]+ "]" + " ");
        }
        System.out.print("\n********************\n");

        for (int i = 0; i < a.length; i++) {
            a[i]*=-1;
        }
        sortIA7(a);//För att roppa upp mathoden Sortering

        for (int i = 0; i < a.length; i++) {
            a[i]*=-1;
        }

        System.out.println("\n********************\n");
        System.out.println("Sorterade element:");

        //För att gå genom hela listen
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" +a[i]+ "]" + " ");
        }
        System.out.println("\n********************\n");
    }
}
