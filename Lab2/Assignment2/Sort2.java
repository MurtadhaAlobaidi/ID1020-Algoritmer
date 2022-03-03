package Assignment2;
import java.util.Scanner;

import static package2.Insertinonsort2.insertionSortCount;
import static package2.Insertinonsort2.sortIA2;

public class Sort2
{
    //För att testa main funktion
    public static void main(String[] args)
    {
        System.out.print("Lab 2 Assignment 2: "); //Skriva ut ämnas för Assignment 2
        System.out.println("\n-----------------------\n");
        System.out.println("Skriv storlek på listan: ");
        Scanner s = new Scanner(System.in); //Ta emot Input
        int [] a  = new int[s.nextInt()]; //Input
        System.out.println("Skriva element till listan:");
        for (int i = 0; i < a.length; i++) {

            a[i]=s.nextInt(); //nya listen
        }
        System.out.println("***********************");

        //Skriva ut listen innan sortering
        System.out.println("Din Input: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" +a[i]+ "]" + " ");
        }
        System.out.println("\n***********************");
        //Skriva ut nummer av inversions
        System.out.println("Number of inversions are "+ "["+ insertionSortCount(a) + "]");
        System.out.println("\n***********************");

        sortIA2(a);//För att roppa upp mathoden Sortering

        System.out.println("********************");
        System.out.println("\nSorterade element:");
                //För att gå genom hela listen
              for (int i = 0; i < a.length; i++) {
            System.out.print("[" +a[i]+ "]" + " ");
             }
        System.out.println("\n********************\n");
    }
}