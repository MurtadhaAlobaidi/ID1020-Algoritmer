package package3;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue3 {
    public static class Queue<key> implements Iterable<key> {
        // beginning of queue
        private Node<key> first;
        private Node<key> prev;
        // number of elements on queue
        private int n;

        // helper linked list class
        private class Node<Item> {
            private Item item;
            private Node<Item> next;
        }

        //Initializes an empty queue.
        public Queue() {
            first = null;
            prev = null;
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
        public key peek() {
            if (isEmpty()) throw new NoSuchElementException("Se först Node");
            return first.item;
        }

        //Add ett ord till siste
        //Lägger till objektet i den här kön.
        public void enqueue(key item) {
            Node<key> oldlast = prev;
            prev = new Node<key>();

            prev.item = item;
            prev.next = null;

            if (isEmpty())
                first = prev;
            else
                oldlast.next = prev;
            n++;
        }

        //Removes and returns the item on this queue that was least recently added.
        //@return the item on this queue that was least recently added
        //@throws NoSuchElementException if this queue is empty
        public key dequeue() {
            if (isEmpty())
                throw new NoSuchElementException("Lämna tillbaka vad du hade");

            key item = first.item;
            first = first.next;

            n--;

            if (isEmpty())
                prev = null;   // to avoid loitering

            return item;
        }

        //Returns a string representation of this queue.
        //@return the sequence of items in FIFO order, separated by spaces
        //Att se queue som string
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (key item : this) {
                s.append(item);
                s.append(' ');
            }
            return s.toString();
        }

        //Returns an iterator that iterates over the items in this queue in FIFO order.
        //@return an iterator that iterates over the items in this queue in FIFO order
        //Den titta upp på alla elmenter som finns i queue
        public Iterator<key> iterator() {
            return new LinkedIterator(first);
        }

        // an iterator, doesn't implement remove() since it's optional
        private class LinkedIterator implements Iterator<key> {
            private Node<key> current;

            public LinkedIterator(Node<key> first) {
                current = first;
            }

            public boolean hasNext() {
                return current != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public key next() {
                if (!hasNext()) throw new NoSuchElementException();
                key item = current.item;
                current = current.next;
                return item;
            }
        }
    }
}











