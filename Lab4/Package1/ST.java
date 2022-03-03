package Package1;
/*
 *@author: code taken from Robert Sedgewick and Kevin Wayne.
 *Algorithms & Datastructures: KTH ID1021-HT21-1. Tillägg Murtadha Alobaidi
 *Lab4-Q1
 *BST(from kapitel 3) Symboltabell krävs för att köra SymbolGraph.
 */
public class ST<Key extends Comparable<Key>, Value>
{
    private Node root; // root of ST

    private class Node
    {
        private Key key; // key
        private Value val; // associated value
        private Node left, right; // links to subtrees
        private int N; //noder i subtree rotade här

        public Node(Key key, Value val, int N)
        {
            this.key = key;//nyckel
            this.val = val;//Vale
            this.N = N;//noder i subtree rotade här
        }
    }

    //Returnerar antalet nyckel-värdepar i denna symboltabell.
    public int size() {return size(root);}

    // returnera antal nyckel-värdepar i ST med rötterna x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    //Returnerar värdet som är associerat med den angivna nyckeln.
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key)
    {
        // Returvärde associerat med nyckeln i delträdet som är rotat till x;
        //returnera null om nyckeln inte finns i subtree rotad på x.
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

   //Infogar det angivna nyckel-värdeparet i symboltabellen och skriver över det gamla
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val)
    {
        //Ändra nyckelns värde till val om nyckeln i subtree är rotad till x.
        //Annars lägger du till en ny nod i delträdets associeringsnyckel med val.
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //Innehåller denna symboltabell den angivna nyckeln?
    public boolean contains(Key key)
    {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains() cannot be null");
        }
        return get(key) != null;
    }

    //Returnerar alla nycklar i symboltabellen
    //För att iterera över alla nycklar i symboltabellen med namnet
    public Iterable<Key> keys() {
        return keys(min(), max());
    }


    /* Returns all keys in the symbol table in the given range,
    * lo minsta slutpunkt
    * hi maximal slutpunkt
    * återställ alla nycklar i symboltabellen mellan lo och hi
     */
    public Iterable<Key> keys(Key lo, Key hi)
    {
        LinkedStack<Key> queue = new LinkedStack<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, LinkedStack<Key> queue, Key lo, Key hi)
    {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.push(x.key);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }

    public Key min () {return min(root).key;}

    private Node min (Node x)
    {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max (){return max(root).key;}

    private Node max (Node x)
    {
        if (x.right == null) return x;
        return max(x.right);
    }

}
