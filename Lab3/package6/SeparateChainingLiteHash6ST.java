package package6;
import package3.Queue3;
import package5.SeparateChainingLiteHashST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/******************************************************************************
     *  Compilation:  javac SeparateChainingLiteHashST.java
     *  Execution:    java SeparateChainingLiteHashST
     *  Dependencies: StdIn.java StdOut.java
     *
     *  A symbol table implemented with a separate-chaining hash table.
     *
     *  Note 1: does not support delete().
     *  Note 2: does not do resizing.
     *
     *  % java SeparateChainingLiteHashST < tinyTale.txt
     *
     ******************************************************************************/
 public class SeparateChainingLiteHash6ST<Key, Value> {
    private int n;       // number of key-value pairs
    private int m;       // hash table size
    private Node[] st;   // array of linked-list symbol tables

    // a helper linked list data type
    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // create separate chaining hash table
    public SeparateChainingLiteHash6ST() {
        this(997);
    }

    // create separate chaining hash table with m lists
    public SeparateChainingLiteHash6ST(int m) {
        this.m = m;
        st = new Node[m];
    }

    // hash value between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    // return number of key-value pairs in symbol table
    public int size() {
        return n;
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // is the key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with key, null if no such key
    public Value get(Key key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    // insert key-value pair into the table
    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        n++;
        st[i] = new Node(key, val, st[i]);
    }

    // delete key (and associated value) from the symbol table
    public void delete(Key key) {
        throw new UnsupportedOperationException("delete not currently supported");
    }

    // return all keys as an Iterable
    public Iterable<Key> keys() {
        Queue3.Queue<Key> queue = new Queue3.Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                queue.enqueue((Key) x.key);
            }
        }
        return queue;
    }

    public void print() {
        for (int i = 0; i < m; i++) {
            System.out.println("Index: " + i);
        }
    }
/*
      /***************************************************************************
         *  Unit test client.
         ***************************************************************************/

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Assignment 6");
        System.out.println("*********************");
        SeparateChainingLiteHashST<String, Integer> st = new SeparateChainingLiteHashST<String, Integer>(997);
        File wo = new File("Test3000.txt");
        Scanner sc = new Scanner(wo);//läsa från filen

        while (!sc.hasNext()){
            st.print();
            System.out.println();
        }

      /*  final String s1 = String.valueOf(sc);
        String s = new String(s1);
        char s2 []=s.toCharArray();
        System.out.println(s2);
        System.out.println("Skriv ord: ");
       // Scanner a = new Scanner(System.in);
       // String b = a.nextLine().toLowerCase();

        for (int i =0; i != s.length;i++) {
                  //  System.out.println(s2);
                }
            // System.out.println(s+" ("+ st.get(s)+ ")" + " "+ "Index m lista "+ "["+st.hash(s)+"]");
           // System.out.println(sc + " (" + st.get() + ")");
        }

/*



        /*
        for (int i = 0; sc.hasNext(); i++)
        {
            String key = sc.next();
            st.put(key, i);
        }*/


        //st.print();
        // System.out.println("Hash cod för alla String Words : " );
        //System.out.println("___________________________________" );
      /*  for (String s : st.keys()){
            // System.out.println(s+" ("+ st.get(s)+ ")" + " "+ "Index m lista "+ "["+st.hash(s)+"]");
            System.out.println(s+" ("+ st.get(s)+ ")");
        }*/
        //}

    }
}


