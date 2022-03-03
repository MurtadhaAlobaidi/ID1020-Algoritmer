package package5;

import package3.Queue3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;        // number of key-value pairs
    private int m;        // number of chains
    private Node[] st;    // array of linked-list symbol tables

    // a helper linked list data type
    private static class Node {
        private final Object key;
        private Object val;
        private Node next;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public HashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with {@code m} chains.
     *
     * @param m the initial number of chains
     */
    public HashST(int m) {
        this.m = m;
        st = new Node[m];
    }

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    @SuppressWarnings("unchecked")
    private void resize(int chains) {
        HashST<Key, Value> temp = new HashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                temp.put((Key) x.key, (Value) x.val);
            }
        }

        this.m = temp.m;
        this.n = temp.n;
        this.st = temp.st;
    }

    // hash value between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key};
     * {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param key the key
     * @return the value associated with {@code key} in the symbol table;
     * {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    @SuppressWarnings("unchecked")
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Removes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            remove(key);
            return;
        }
        // double table size if average length of list >= 10
        if (n >= 10 * m) resize(2 * m);

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

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void remove(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to remove() is null");

        int i = hash(key);
        st[i] = remove(st[i], key);

        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2 * m) resize(m / 2);
    }

    // remove key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node remove(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = remove(x.next, key);
        return x;
    }

    /**
     * Returns all keys in the symbol table.
     *
     * @return all keys in the symbol table, as in iterable
     */
    @SuppressWarnings("unchecked")
    public Iterable<Key> keys() {
        Queue3.Queue<Key> queue = new Queue3.Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Node x = st[i]; x != null; x = x.next) {
                queue.enqueue((Key) x.key);
            }
        }
        return queue;
    }


    /**
     * Unit tests the {@code HashST} data type.
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Assignment 5");
        System.out.println("******************");

        System.out.println("Ange key length  : ");//Skriva ut längd på ordet
        // Scanner a = new Scanner(System.in); //Längden på ordet få från användrae


        int minLength = Integer.parseInt(args[0]);    // min length of word
        int minOccurrence = Integer.parseInt(args[1]);    // min number of occurrences


        File wor = new File("Test3000.txt");
        Scanner read = new Scanner(wor);//läsa från filen
        String b = read.next();
        // read in the words from read
        String[] words = new String[10];
        // build symbol table of words and locations
        HashST<String, Queue3.Queue<Integer>> st = new HashST<String, Queue3.Queue<Integer>>();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.length() < minLength) continue;
            if (!st.contains(s)) {
                st.put(s, new Queue3.Queue<Integer>());
            }
            Queue3.Queue<Integer> q = st.get(s);
            q.enqueue(i);
        }
        for (String s : st.keys()) {
            Queue3.Queue<Integer> q = st.get(s);
            /*if (q.length() >= minOccurrence) {
                System.out.println(s + ": " + q);
                System.out.println(s + ": ");

            }*/
        }
    }
}










            /*
            int minlen = a.nextInt();//key-längden
            int distinct = 0;
            int words = 0;

            //Bulid symbol table and count frequencies
            //FrequencyCounter
            while (read.hasNext())
            {
                String wo = read.next().toUpperCase(); //converts a string to upper case letters.
                //om ordet är stora
                if (wo.length() < minlen) continue;//Ignore short keys.
                words++;
                if (st.contains(wo)) st.put(wo, st.get(wo) + 1);
                else
                {
                    st.put(wo, 1);
                    distinct++;
                }
                //char wors= wo.charAt(0);
               // System.out.println(wors);
                //System.out.println(st.hashCode());
                System.out.println("Hashcodes for the word is "+"("+st.hash(wo)+")");
            }
            // find a word with the highest frequency count
            String max = "";
            st.put(max, 0);
            for (String word : st.keys()) {
                if (st.get(word) > st.get(max)) {
                    max = word;
                }
            }






            System.out.println("\nDet vanligaste ordet var: " + "("+max.toUpperCase()+")" +" tryckt "+st.get(max)+ " gångar");

            //System.out.println("Distinct = " );
            //System.out.println("Words = " + words);*/

















