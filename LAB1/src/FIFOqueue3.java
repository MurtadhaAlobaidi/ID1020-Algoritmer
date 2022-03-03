import Stack3.Queue3;
import java.util.Scanner;

public class FIFOqueue3 {
    public static <Item> void main(String[] args) {
        Queue3<String> queue = new Queue3<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Input3:");

        while (s.hasNext()) {
            //(enqueue)Den addare till queue
           queue.enqueue(s.next());
        }

       // System.out.println(queue.toString());
        //(dequeue) Den ta bort från queue
        queue.dequeue();
        System.out.println(queue.toString());
        s.close();
    }
}
