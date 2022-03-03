package package3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main3
{
    //Mathod för starta Time complexity
    public static long start;
    public static void startwatch() {start = System.currentTimeMillis();}
    //Mathod för stopp Time complexity
    public static void elapsedTime() {long end = System.currentTimeMillis();
        System.out.println("\nTime excution : " + (end - start) / 1000.0);
    }
    /**
     * Unit tests the {@code BinarySearchST} data type.
     *
     * @param args the command-line arguments
     */
    /**
     * Unit tests the {@code BST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Assignment 3");
        System.out.println("*********************");

        long start = System.currentTimeMillis();//Start Time

        Assignment3.BST<String, Integer> st = new Assignment3.BST<String, Integer>();
        System.out.println("Ange key length  : ");//Skriva ut längd på ordet
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
            if (wo.length() < minlen) continue;//Ignore short keys.
            words++;
            if (st.contains(wo)) st.put(wo, st.get(wo) + 1);
            else {
                st.put(wo, 1);
                distinct++;
            }
        }
        // find a word with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        long end = System.currentTimeMillis();
        
        
        read.close();
        System.out.println("\nDet vanligaste ordet var: " + "("+max.toUpperCase()+")" +" tryckt "+st.get(max)+ " gångar");
        System.out.println("Distinct = " + distinct);
        System.out.println("Words = " + words);
        System.out.println("Tiden för att hitta den var " + ((end-start)));
    }
}
