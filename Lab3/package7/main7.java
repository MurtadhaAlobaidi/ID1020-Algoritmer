package package7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main7
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Assignment 7");
        System.out.println("*********************");
        Assignment7.BST<String, Integer> st = new Assignment7.BST<String, Integer>();
        File read = new File("Test1000.txt"); //Läsa från filen
        Scanner a = new Scanner(read); //nya listen i a

        int i = 0;
        //FrequencyCounter
        String text = a.next().toLowerCase();
        while (i != 200)
        {
            if (text.length() < 0) continue;
            if (!st.contains(text)) {
                st.put(text, 1);
            } else {
                st.put(text, st.get(text) + 1);
            }
            i++;
            text = a.next().toLowerCase();
        }

        System.out.println("Your text is "+i+ " words");
        System.out.println("Sorted words A >> Z :");
        System.out.println("____________________");
        st.print();

        System.out.println("____________________");
        System.out.println("Sorted words Z >> A :");
        System.out.println("____________________");
        st.printR();

    }

}