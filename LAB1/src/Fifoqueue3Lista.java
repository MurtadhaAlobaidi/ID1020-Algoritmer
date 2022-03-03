import Stack3.Queue3;
import java.util.Scanner;

    public class Fifoqueue3Lista {
        public static <Item> void main(String[] args) {
            //Skapa nytt lista
            Queue3<String> queue = new Queue3<String>();
            //Listen inhåller
            System.out.println("Your Input3:");

            queue.enqueue("hello");
            queue.enqueue("my");
            queue.enqueue("name");
            queue.enqueue("is");
            queue.enqueue("java");

            //Skriv ut listen
            System.out.println(queue.toString());
            //För att tabort första orden
            queue.dequeue();
            //Skriva ut nytt liste
            System.out.println(queue.toString());
        }
    }

