import Stack4.Queue;
public class Task4 {
    public static <Item> void main(String[] args)
    {
        Queue<String> queue = new Queue<String>();
        System.out.println("First queue:");

        queue.enqueue("hello");
        queue.enqueue("my");
        queue.enqueue("name");
        queue.enqueue("is");
        queue.enqueue("Murtadha");

        System.out.println( "your text is :" + queue.toString());
        System.out.println("the size is: " + queue.size());
        System.out.println();
        System.out.println("the deleted item is: " + queue.dequeue1());
        System.out.println( "your text is :" + queue.toString());
        System.out.println("the size is: " + queue.size());
        System.out.println();
        System.out.println("Item to delete next is: " + queue.dequeue1());
        System.out.println( "your text is :" + queue.toString());
        System.out.println("the size is: " + queue.size());
        System.out.println();
        System.out.println("the deleted item is: " + queue.dequeue1());
        System.out.println( "your text is :" + queue.toString());
        System.out.println("the size is: " + queue.size());
        System.out.println();
        System.out.println("the deleted item is: " + queue.dequeue1());
        System.out.println( "your text is :" + queue.toString());
        System.out.println("the size is: " + queue.size());
        System.out.println();
        System.out.println("the deleted item is: " + queue.dequeue1());
        System.out.println( "your text is :" + queue.toString());
        System.out.println("the size is: " + queue.size());


        System.out.println("************************************************");

        Queue<String> queue1 = new Queue<String>();
        System.out.println("Second queue:");
        queue1.enqueue("hello");
        queue1.enqueue("my");
        queue1.enqueue("name");
        queue1.enqueue("is");
        queue1.enqueue("Murtadha");

        System.out.println("your text is: " + queue1.toString());
        queue1.enqueue( "New");
        System.out.println("the Add item is: " + "New");
        System.out.println("your new text is: " + queue1.toString());

        System.out.println("************************************************");

        Queue<String> queue3 = new Queue<String>();
        System.out.println("Therst queue:");
        queue3.enqueue("hello");
        queue3.enqueue("my");
        queue3.enqueue("name");
        queue3.enqueue("is");
        queue3.enqueue("Murtadha");

        System.out.println( "your text is :" + queue3.toString());
        System.out.println("the deleted item is: " + queue3.dequeue());
        System.out.println( "your new text is :" + queue3.toString());
        System.out.println();
        System.out.println( "your text is :" + queue3.toString());
        System.out.println("the deleted item is: " + queue3.dequeue());
        System.out.println( "your new text is :" + queue3.toString());
        System.out.println();
        System.out.println( "your text is :" + queue3.toString());
        System.out.println("the deleted item is: " + queue3.dequeue());
        System.out.println( "your new text is :" + queue3.toString());
        System.out.println();
        System.out.println( "your text is :" + queue3.toString());
        System.out.println("the deleted item is: " + queue3.dequeue());
        System.out.println( "your new text is :" + queue3.toString());
        System.out.println();
        System.out.println( "your text is :" + queue3.toString());
        System.out.println("the deleted item is: " + queue3.dequeue());
        System.out.println( "your new text is :" + queue3.toString());

        System.out.println("****************************************************************");

        Queue<String> queue4 = new Queue<String>();
        System.out.println("Ford queue:");

        queue4.enqueue("hello");
        queue4.enqueue("my");
        queue4.enqueue("name");
        queue4.enqueue("is");
        queue4.enqueue("Murtadha");
        System.out.print( "your text is :");
        System.out.println(queue4.toString());
        System.out.println("the Add item is: " + "New");
        queue4.enqueue1("New");

        System.out.print( "your new text is :");
        System.out.print(queue4.dequeue()+" ");
        System.out.print(queue4.dequeue()+" ");
        System.out.print(queue4.dequeue()+" ");
        System.out.print(queue4.dequeue()+" ");
        System.out.print(queue4.dequeue()+" ");
        System.out.print(queue4.dequeue()+" ");
    }
}

