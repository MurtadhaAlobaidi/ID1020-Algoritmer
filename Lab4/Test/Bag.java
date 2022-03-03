package Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item>
{
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag
    // helper linked list class
    private static class Node<Item> {
        private Item item;   //addresen av Node
        private Node<Item> next; //next för Node
    }
    //Tom bag
    public Bag() {
        first = null;
        n = 0;
    }

    //Addera item till bag
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    //
    public Iterator<Item> iterator()  {return new LinkedIterator(first);}

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item>
    {
        private Node<Item> current;
        public LinkedIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext()  { return current != null;}
        public void remove() { throw new UnsupportedOperationException();  }
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}

