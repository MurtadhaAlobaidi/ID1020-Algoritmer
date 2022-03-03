package package2;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Assignment2 {
    //Mathod för starta Time complexity
    public static long start;
    public static void startwatch() {start = System.currentTimeMillis();}
    //Mathod för stopp Time complexity
    public static void elapsedTime() {long end = System.currentTimeMillis();
        System.out.println("\nTime excution : " + (end - start) / 1000.0);
    }
    //Main funcktion för testa
    public static void main(String[] args) throws IOException {
        System.out.println("Assignment 2");
        System.out.println("*********************");

        long start = System.currentTimeMillis();//Start Time

        task2<String, Integer> stt = new task2<String, Integer>();//stt create orderd symbol table
        System.out.println("Ange key-length  : ");//Skriva ut längd på ordet
        Scanner a = new Scanner(System.in); //Längden på ordet få från användrae
        File wor = new File("Test1000.txt");
        Scanner read = new Scanner(wor);//läsa från filen

        int minlen = a.nextInt();//key-längden
        int distinct = 0;
        int words = 0;
        //FrequencyCounter
        while (read.hasNext())
        {
            //Bulid symbol table and count frequencies
            String wo = read.next().toUpperCase(); //converts a string to upper case letters.
            //om ordet är stora
            if (wor.length() < minlen) continue;//Ignore short keys.
            words++;
            if (stt.contains(wo)) stt.put(wo, stt.get(wo) + 1);
             else {
                stt.put(wo, 1);
                distinct++;
            }
        }
        // find a word with the highest frequency count
        String max = "";
        stt.put(max, 0);
        for (String word : stt.keys()) {
            if (stt.get(word) > stt.get(max)) {
                max = word;
            }
        }
        long end = System.currentTimeMillis();//Klockan
        read.close();
        System.out.println("\nDet vanligaste ordet var: " + "("+max.toUpperCase()+")" +" tryckt "+stt.get(max)+ " gångar");
        System.out.println("Distinct = " + distinct);
        System.out.println("Words = " + words);
        System.out.println("Tiden för att hitta den var " + ((end-start)));
    }
}