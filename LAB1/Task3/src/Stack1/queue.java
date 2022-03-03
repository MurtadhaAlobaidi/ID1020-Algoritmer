package Stack4;

public class queue() {
    private Node first = null;

    public class Node() {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node olfirst = first;
        first = new Node();
        first.item = item;
        first.next = olfirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public void enqueue(Item item) {
    }

    public Item dequeue() {
    }

    public int size() {
    }

}
}