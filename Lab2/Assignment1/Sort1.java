package Assignment1;
import java.util.Scanner;
import static package1.Insertinonsort1.sortIA1;
public class Sort1
    {
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
                a[i]=s.nextInt(); //nya listen
            }
            //För att skriva ut hela input listen utan sotering
            System.out.print("Din Input: ");
            for (int i = 0; i < a.length; i++) {
                System.out.print("[" +a[i]+ "]" + " ");
            }
            System.out.print("\n********************\n");
            sortIA1(a);//För att roppa upp mathoden Sortering

            System.out.println("\n********************\n");
            System.out.println("Sorterade element:");

            //För att gå genom hela listen
            for (int i = 0; i < a.length; i++) {
                System.out.print("[" +a[i]+ "]" + " ");
            }
            System.out.println("\n********************\n");
        }

    }


