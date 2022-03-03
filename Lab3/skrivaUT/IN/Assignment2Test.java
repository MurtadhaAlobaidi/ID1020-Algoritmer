package skrivaUT.IN;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Assignment2Test
{
            //Mathod för starta Time complexity
            public static long start;
            public static void startwatch()
            {
                start = System.currentTimeMillis();
            }
            //Mathod för stopp Time complexity
            public static void elapsedTime()
            {
                long now = System.currentTimeMillis();
                // System.out.println("\n");
                System.out.println("\nTime för skriva ut  : "+(now - start)/ 1000.0+" millisecond");
            }



    public static void main(String[] args) throws IOException
    {
            startwatch();//Start Time för Insertion
            task2Test<String, Integer> stt = new task2Test<String, Integer>(); //roppa upp stt
            File read = new File("Test1.txt"); //Läsa från filen

            Scanner a = new Scanner(read);//texten från filen har sparat i a array
            String wo = a.next();//a läser alla stora och små bokstäver och spara i wo
        try {
            FileWriter wo1 = new FileWriter("Test3000.txt");//för att skriva på filen

            int i = 0;
                while (i!=5) //Så jag kan bestämma hur mycket ord jag vill
                {
                    //frequency counts
                        if (wo.length() < 0) continue;
                        if (!stt.contains(wo)) {
                            stt.put(wo,  1);
                        }
                        else {
                            stt.put(wo, stt.get(wo)+1);
                        }
                        i++;
                        wo=a.next().toUpperCase();//alla ord ta små bokstäver och skrivs med stora bokstäver
                        //Skriva ut vad du Läsa från stor fil
                        System.out.println(wo);

                        wo1.write(wo + "\n");//add till filen
                }
                wo1.close();//filen stäng efter skrivning
        }
            catch (IOException e)
            {
                 e.printStackTrace(); //om det finns fel den stoppa
            }
        elapsedTime(); //stopp Time excution
    }
}






