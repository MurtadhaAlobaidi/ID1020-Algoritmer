import Stack6.Task_6;

import java.util.Random;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args){
        Task_6 myQ = new Task_6();

        Scanner scan = new Scanner(System.in);
        System.out.println("How many integers do you want to enter? answer with an integer number");
        int count = scan.nextInt();

        int[] n = new int[count];
        System.out.println("Please enter your integers:");

        Random rand = new Random();

        for(int i = 0; i < count; i++){
            n[i]= scan.nextInt();
            myQ.addAndSort(n[i]);
        }
        System.out.println(n);
    }
}
