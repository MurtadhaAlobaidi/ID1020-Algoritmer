package package5;
import package3.Queue3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

 public class SeparateChainingLiteHashST<Key, Value>
  {
        private int n;       // number of key-value pairs
        private int m;       // hash table size
        private Node[] st;   // array of linked-list symbol tables

        // a helper linked list data type
        private static class Node {
            private Object key;
            private Object val;
            private Node next;

            public Node(Object key, Object val, Node next)  {
                this.key  = key;
                this.val  = val;
                this.next = next;
            }
        }

        // create separate chaining hash table with m lists
        public SeparateChainingLiteHashST(int m) {
            this.m = m;
            st = new Node[m];
        }

        // hash value between 0 and m-1
        private int hash(Key key) {
            return (key.hashCode() & 0x7fffffff) % m;
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

        // return all keys as an Iterable
        public Iterable<Key> keys()
        {
            Queue3.Queue<Key> queue = new Queue3.Queue<Key>();
            for (int i = 0; i < m; i++)
            {
                for (Node x = st[i]; x != null; x = x.next) {
                    queue.enqueue((Key) x.key);
                }
            }
            return queue;
        }

      public void print ()
      {
          for (int i = 0; i < m ; i++)
          {
            //System.out.println("Index: " + i );
          }
      }

        public static void main(String[] args) throws FileNotFoundException
        {
            System.out.println("Assignment 5");
            System.out.println("*********************");
            SeparateChainingLiteHashST<String, Integer> st = new SeparateChainingLiteHashST<String, Integer>(997);

            File wo = new File("Test1000.txt");
            Scanner sc = new Scanner(wo);//läsa från filen

            for (int i = 0; sc.hasNext(); i++)
            {
                String key = sc.next();
                st.put(key, i);
            }
            st.print();
            System.out.println("Hash cod för alla String Words : " );
            System.out.println("___________________________________" );
            for (String s : st.keys()){
               // System.out.println(s+" ("+ st.get(s)+ ")" + " "+ "Index m lista "+ "["+st.hash(s)+"]");
                System.out.println(s+" ("+ st.get(s)+ ")");
            }
        }
  }

