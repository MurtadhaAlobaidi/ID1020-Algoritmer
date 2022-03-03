import queue5.Queue5;
public class Task5 {
    public static <Item> void main(String[] args) {
        //Skappa nytt liste
        Queue5<String> lista = new Queue5<String>();
       // System.out.println("Your list size:");

        lista.enqueue("hello");
        lista.enqueue("my");
        lista.enqueue("name");
        lista.enqueue("is");
        lista.enqueue("New");
        lista.enqueue("kth");

        //System.out.println(lista.size());
        System.out.println("your list is : " + lista.toString());
        //Ta bort en index
       lista.removeK(6);

       System.out.println("your list is : " + lista.toString());
    }
}
