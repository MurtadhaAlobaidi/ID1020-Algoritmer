import java.util.Scanner;
public class Assemint_6 {
    Node first;
    Node prev;
    int saize;
//Nytt Node
    public class Node {
        int item;
        Node next;

        public Node( int m) {
            this.item = m;
            this.next = null;
        }
    }
    //Tomt
    public boolean isEmpty(){
        return saize == 0;
    }
    public int size(){
        return saize;
    }

    //För att sotera och add
    public void sortering(int newM){
        //Nytt node
        Node nyttNode = new Node(newM);
        if(isEmpty()){
            first = nyttNode;
            prev = first;
            prev.next = first;

        } else if(saize == 1)
        {
            if(first.item > newM){

                nyttNode.next = prev.next;
                first = nyttNode;
                prev.next = first;

            } else {
                first.next = nyttNode;
                prev = nyttNode;
                prev.next = first;
            }
        } else if(saize >1) {
            if (first.item > newM) {
                nyttNode.next = prev.next;
                first = nyttNode;
                prev.next = first;
            } else {
                Node pekare = first;
                while (pekare.next != first) {
                    if (pekare.next.item > newM) {
                        break;
                    } else {
                        pekare = pekare.next;
                    }
                }
                Node gammalNode = pekare.next;
                nyttNode.next = gammalNode;
                pekare.next = nyttNode;
                pekare.next.next = nyttNode.next;
                if (newM > prev.item) {
                    Node oldTail = prev;
                    oldTail.next = nyttNode;
                    prev = nyttNode;
                }
                prev.next = first;
            }
        }
        saize++;
    }
//För att skriva ut
    public String toString2(){
        Node pekare2 = first;
        int pos = 0;
        int p = saize -1;
        int [] numbers = new int[saize];
        while (p >= 0){
            numbers[pos] = pekare2.item;
            pekare2 = pekare2.next;
            pos++;
            p--;
        }
        return "Your queue contains the following integers: \n"  + java.util.Arrays.toString(numbers);
    }

    //För att testa
    public static void main(String[] args){
        Assemint_6 queue6 = new Assemint_6();

        Scanner scan = new Scanner(System.in);
        System.out.println("How many integers do you want to enter? answer with an integer number");
        int count = scan.nextInt();

        int[] n = new int[count];
        System.out.println("Please enter your integers:");

        for(int i = 0; i < count; i++){
            n[i]= scan.nextInt();
            queue6.sortering(n[i]);
        }
        System.out.println(queue6.toString2());
    }
}