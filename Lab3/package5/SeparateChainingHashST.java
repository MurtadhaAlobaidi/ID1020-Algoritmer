package package5;
import package3.Queue3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables


    // Murtadha 1 a helper linked list data type



    /**
     * Initializes an empty symbol table.
     * Murtadha byta till tabel som jag vill 1000 ord
     */
    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with {@code m} chains.
     *
     * @param m the initial number of chains
     *          Murtadha KOLLA på den 1000 ord
     */
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }

    // resize the hash table to have the given number of chains,
    // rehashing all of the keys
    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m = temp.m;
        this.n = temp.n;
        this.st = temp.st;
    }

    // hash function for keys - returns value between 0 and m-1
    private int hashTextbook(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    // hash function for keys - returns value between 0 and m-1 (assumes m is a power of 2)
    // (from Java 7 implementation, protects against poor quality hashCode() implementations)
    private int hash(Key key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (m - 1);
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
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        // double table size if average length of list >= 10
        if (n >= 10 * m) resize(2 * m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        // halve table size if average length of list <= 2
        if (m > INIT_CAPACITY && n <= 2 * m) resize(m / 2);
    }

    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        Queue3.Queue<Key> queue = new Queue3.Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }


    /**
     * Unit tests the {@code SeparateChainingHashST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        File wo = new File("Test3000.txt");
        Scanner read = new Scanner(wo);//läsa från filen




      //  String b = s.toLowerCase();
        //System.out.println(b.hashCode());


        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
      /*
        String s = read.next();
        for (int i = 0; i < s.length(); i++) {
            char c[] = s.charAt(i);
            Integer val = st.get(c);
            if (val != null) {
                st.put(c, new Integer(val + 1));
            }
            else {
                st.put(c, 1);
            }
        }
*/

       // s.charAt(1);
        //System.out.println(s.charAt(1));
       // int hash1=s.hashCode();
        //System.out.println(s);


       // st.put(s, 1);
        //st.put(s, 5);
       // st.put(s, 1);

        //System.out.println(s.charAt(2));


        //   h = s[i] + (31 * h); hash = h;


        // System.out.println("Ange key length  : ");//Skriva ut längd på ordet
        // Scanner a = new Scanner(System.in); //Längden på ordet få från användrae
        //  int minlen = a.nextInt();//key-längden

        //   String s = read.nextLine();
        // int hash=0;
        //for (int i = 0; s.length; i++) {
        //  hash=(R*hash+s.charAt(i))%M;


        //  String key = read.next().toUpperCase();
        //st.put(key, i);
        // }

        // print keys
        //   for (String s : st.keys())
        //     System.out.println(s + " " + st.get(s));
        //   System.out.println();
        //  }
/*
        public final class String
        {
            private int hash = 0;
            private final char[] s;

            public String(char[] s) {
                this.s = s;
            }

            public int hashCode()
            {
                int h = hash;
                if (h != 0) return h;
              //  for (int i = 0; i < length(); i++)
                 //   h = s[i] + (31 * h); hash = h;
                return h;
            }
        }

*/


    }
}
