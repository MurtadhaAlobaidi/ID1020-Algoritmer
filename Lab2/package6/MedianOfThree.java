package package6;
public class MedianOfThree {
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sortMedian(int[] a) {
        sortQ(a, 0, a.length - 1);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sortQ(int[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int median = medianOf3(a, lo, lo + (hi - lo)/2, hi);
        exch(a,lo ,median); //jämföra median med lo
        int j = partition(a, lo, hi); //
        sortQ(a, lo, j-1);
        sortQ(a, j+1, hi);
    }

    // return the index of the median element among a[i], a[j], and a[k]
    private static int medianOf3(int[] a, int i, int j, int k)
    {
        return ((a[i]< a[j]) ?
                ((a[j] < a[k]) ? j : (a[i] <a[k]) ? k : i) :
                ((a[k] < a[j]) ? j : (a[k] <a[i]) ? k : i));
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(int[] a, int lo, int hi)
    {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            // find item on lo to swap
            while ((a[++i] < v )) {
                if (i == hi) break;
            }
            // find item on hi to swap
            while ((v < a[--j] )) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }
            // check if pointers cross
            if (i >= j) break;
            exch(a, i, j);
        }
        // put partitioning item v at a[j]
        exch(a, lo, j);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    // is v < w ?
    private static boolean less(int v, int w) {
        if (v == w) return false;   // optimization when reference equals
        return v<w;
    }
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = (int) swap;
    }
    /*************************
     *  Check if array is sorted - useful for debugging.
     *************************/
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // print array to standard output
    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("["+a[i]+"]");
        }
    }
}
