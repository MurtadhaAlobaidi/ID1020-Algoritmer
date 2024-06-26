package Stack6;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task_6<Item> implements Iterable<Item>
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
        //längd
        int n;
    }

    //Initializes an empty queue. Konstrakter
    public Task_6()
    {
        first = null;
        last  = null;
        n = 0;
    }

    //Returns true if this queue is empty.
    public boolean isEmpty()
    {
        return first == null;
    }

    //Returns the number of items in this queue.
    public int size()
    {
        return n;
    }

    //Returns the item least recently added to this queue.
    //@return the item least recently added to this queue
    //@throws NoSuchElementException if this queue is empt
    public Item peek()
    {
        if (isEmpty()) throw new NoSuchElementException("Se först Node");
        return first.item;
    }

    //Adds the item to this queue.
    //@param  item the item to add
    public void enqueue(Item item)
    {
        Node<Item> oldlast = last;
        last = new Node<Item>();

        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        n++;
    }

    public void addAndSort( int newitem)
    {
        Node<Item> m = first;
        first = new Node<Item>();

        if (isEmpty())
        {
        last = first;
        last.next = first;
        }

        else if (n==1)
        {
            if (first.n >newitem)
            {

                m.next=last.next;
                first=m;
                last.next=first;
            }
            else{
                first.next=m;
                last=m;
                last.next=first;
            }
            if  (n>1)
            {
                if (first.n > newitem)
                {
                  m.next=last.next;
                  first=m;
                  last.next=first;
                }
                else
                {
                    Node j=first;

                    while (j.next!=first)
                    {
                        if (j.next.n > newitem){
                            break;
                        }
                        else
                        {
                            j=j.next;
                        }
                    }
                    Node oldnode=j.next;
                    m.next=oldnode;
                    j.next.next=m.next;
                    if (newitem>last.n){
                        Node oldlast=last;
                        oldlast.next=m;
                        last=m;
                    }
                    last.next=first;
                }
            }

        }
        n++;
    }

    //Removes and returns the item on this queue that was least recently added.
    //@return the item on this queue that was least recently added
    //@throws NoSuchElementException if this queue is empty
    public Item dequeue()
    {
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
    //Returns an iterator that iterates over the items in this queue in FIFO order.
    //@return an iterator that iterates over the items in this queue in FIFO order
    //Den titta upp på alla elmenter som finns i queue
    public Iterator<Item> iterator()
    {
        return new LinkedIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;
        public LinkedIterator(Node<Item> first)
        {
            current = first;
        }
        public boolean hasNext()
        {
            return current != null;
        }
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}