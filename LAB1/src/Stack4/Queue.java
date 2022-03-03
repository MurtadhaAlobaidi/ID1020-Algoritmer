package Stack4;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Queue<Item> implements Iterable<Item>
{
    // beginning of queue
    private Node<Item> first;
    // end of queue
    private Node<Item> last;
    // number of elements on queue
    private int n;
    // helper linked list class
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;

        public Node(Item newItem){
            item = newItem;
            next = null; }
    }
    //bygga och bredda an empty queue.
    public Queue()
    {
        first = null;
        last  = null;
        n = 0;
    }
    //Returns true if this queue is empty.
    public boolean isEmpty()
    {
        return first == null;}
    //Returnerar antalet objekt i den här kön.
    public int size()
    {
        return n;}
    //Returnerar objektet som senast lagts till i den här kön.
    //@returnera varan som minst har lagts till i den här kön
    //@kastar NoSuchElementException om den här kön är tom
    public Item peek()
    {
        if (isEmpty()) throw new NoSuchElementException("Se först Node");
        return first.item;
    }
    //Add ett ord till siste
    //Lägger till objektet i den här kön.
    public void enqueue(Item item)
    {
        Node<Item> oldlast = first;
        first = new Node<Item>(item);

        first.item = item;
        first.next = null;
/*
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;*/
        n++;
    }
    //Remove from siste ord (java)
    public Item dequeue1()
    {
        if (isEmpty())
            throw new NoSuchElementException("Lämna tillbaka vad du hade");
        Item item =last.item;
        if(n == 1){
            last = null;
            first = null;
        }
        else if (n == 2){
            last = first;
            first.next=null;
        }
        else if (n > 2){
            Node<Item> temp = first;
            while(temp.next.next!= last){
                temp = temp.next;
            }
            last = temp.next;
            temp.next.next=null;
        }
        n--;
        if (isEmpty())
            last = null;   // to avoid loitering
        return item;
    }
    //Add ord till början
    public void enqueue1 (Item item) {
        Node<Item> newFirst = new Node<Item>(item);
        newFirst.item = item;
        if (n==0){
            first= newFirst;
            last = first;
        } else if (n == 1){
            Node<Item> oldFirst = first;
            newFirst.next = oldFirst;
            last.next = newFirst;
            first = newFirst;
        } else if(n > 1){
            Node<Item> oldFirst = first;
            first = newFirst;
            first.next = oldFirst;
            last.next = first;
        }
        n++;
        if (isEmpty())
            last = null;   // to avoid loitering
        n++;
        return ;
    }
    //Remove ord från början
    //Tar bort och returnerar objektet i den här kön som minst nyligen har lagts till.
    //returnera objektet i den här kön som minst nyligen har lagts till
    //kastar NoSuchElementException om den här kön är tom
    public Item dequeue()
    {
        if (isEmpty())
            throw new NoSuchElementException("Lämna tillbaka vad du hade");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;
        return item;
    }
    //Returns a string of this queue.
    //@return the I fifo med mellanslag
    //Att se queue som string
    public String toString()
    {
        StringBuilder s = new StringBuilder();

        for (Item item : this)
        {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    //Returnerar en iterator som iterates över objekten i denna kö i FIFO ordning.
    //@return a iterator that iterates over the items in den queue I FIFO order.
    //Den titta upp på alla elmenter som finns i queue
    public Iterator<Item> iterator()
    {
        return new LinkedIterator(first);}
    // an iterator, implementerar inte remove() eftersom det är valfritt
    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;
        public LinkedIterator(Node<Item> first)
        {
            current = first;}
        public boolean hasNext()
        {
            return current != null;}
        public void remove()
        {
            throw new UnsupportedOperationException(); }
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}