package queue5;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Queue5<Item> implements Iterable<Item> {
    // beginning of queue
    private Node first;
    // end of queue
    private Node last;
    // number of elements on queue
    private int n;
    // helper linked list class
     private class Node {
         Item item;
         Node next;
    }
    //Initializes an empty queue.
    public Queue5() {
        first = null;
        last = null;
        n = 0;
    }
    //Returns true if this queue is empty.
    public boolean isEmpty() {
        return first == null;
    }
    //Returnerar antalet objekt i den här kön.
    public int size() {
        return n;
    }
    //Returnerar objektet som senast lagts till i den här kön.
    //@returnera varan som minst har lagts till i den här kön
    //@kastar NoSuchElementException om den här kön är tom
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Se först Node");
        return first.item;
    }
    //För att ta bort index från listen
    public Item removeK(int k){
        Item kth;
         kth=first.item;
         if(k==1)
             first=first.next;
        else {
             Node m = first;
             //För att ta bort nästa index
             int i = k - 1;
             int a = 1;

             while ((a < i)) {
                 m = m.next;
                 a++;
             }
             kth = m.item;
             m.next = m.next.next;
         }
        return kth;
    }
    //Add ett ord till siste
    //Lägger till objektet i den här kön.
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();

        last.item = item;
        last.next = null;

        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        n++;
    }
    //Remove ord från början
    //Tar bort och returnerar objektet i den här kön som minst nyligen har lagts till.
    //returnera objektet i den här kön som minst nyligen har lagts till
    //kastar NoSuchElementException om den här kön är tom
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Lämna tillbaka vad du hade");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;   // to avoid loitering
        return item;
    }
    //Returns a string representation of this queue.
    //@return the sequence of items in FIFO order, separated by spaces
    //Att se queue som string
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    //Returns an iterator that iterates over the items in this queue in FIFO order.
    //@return an iterator that iterates over the items in this queue in FIFO order
    //Den titta upp på alla elmenter som finns i queue
    public Iterator<Item> iterator() {
        return new Queue5.LinkedIterator(first);
    }
    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node current;
        public LinkedIterator(Node first) {
            current = first;
        }
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}