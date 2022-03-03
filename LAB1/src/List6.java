import java.util.Scanner;
public class List6 {
        Node head;
        Node tail;
        int len;


        public class Node {
            int value;
            Node next;

            public Node( int newValue) {
                this.value = newValue;
                this.next = null;
            }
        }
        public boolean isEmpty(){
            return len == 0;
        }
        public int size(){
            return len;
        }

        public void addAndSort(int newValue){
            Node newNode = new Node(newValue);
            if(isEmpty()){
                head = newNode;
                tail = head;
                tail.next = head;
            } else if(len == 1){
                if(head.value > newValue){
                    newNode.next = tail.next;
                    head = newNode;
                    tail.next = head;
                } else {
                    head.next = newNode;
                    tail = newNode;
                    tail.next = head;
                }
            } else if(len>1) {
                if (head.value > newValue) {
                    newNode.next = tail.next;
                    head = newNode;
                    tail.next = head;
                } else {
                    Node temp = head;
                    while (temp.next != head) {
                        if (temp.next.value > newValue) {
                            break;
                        } else {
                            temp = temp.next;
                        }
                    }
                    Node oldNode = temp.next;
                    newNode.next = oldNode;
                    temp.next = newNode;
                    temp.next.next = newNode.next;
                    if (newValue > tail.value) {
                        Node oldTail = tail;
                        oldTail.next = newNode;
                        tail = newNode;
                    }
                    tail.next = head;
                }
            }
            len++;
        }

        public String toString2(){
            Node temp = head;
            int i = 0;
            int j = len-1;
            int [] numbers = new int[len];
            while (j >= 0){
                numbers[i] = temp.value;
                temp = temp.next;
                i++;
                j--;
            }
            return "Your queue contains the following integers: \n"  + java.util.Arrays.toString(numbers);
        }

        public static void main(String[] args){
            List6 myQ = new List6();

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your integers: \n");
            int []a = new int[scan.nextInt()];
            while (scan.nextLine() != "\n"){
                myQ.addAndSort(scan.nextInt());
            }
            System.out.println(myQ.toString2());

            /*myQ.addAndSort(2);
            myQ.addAndSort(3);
            myQ.addAndSort(7);
            myQ.addAndSort(9);*/
            System.out.println(myQ.toString2());

            /*myQ.addAndSort(1);
            System.out.println(myQ.toString2());

            myQ.addAndSort(10);
            System.out.println(myQ.toString2());

            myQ.addAndSort(8);
            System.out.println(myQ.toString2());*/

        }
    }
