package package5;
public class MergeX {
    private static final int CUTOFF = 30;  // cutoff to insertion sort

    private static void merge(int[] src, int[] dst, int lo, int mid, int hi) {
        // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              dst[k] = src[j++];//Den första halava array (höger)
            else if (j > hi)               dst[k] = src[i++];//Den andra halava nytt array(vänster)
            else if (less(src[j], src[i])) dst[k] = src[j++];//vilken är mindre aux[j] < aux[i] sätta den först
            else                           dst[k] = src[i++];//lo den stämmer när den mindre
        }
    }
    private static void sortX(int[] src, int[] dst, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sortX(dst, src, lo, mid);
        sortX(dst, src, mid+1, hi);

        // using System.arraycopy() is a bit faster than the above loop
        if (!less(src[mid+1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi);
    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sortX(int[] a) {
        int[] aux = a.clone();
        sortX(aux, a, 0, a.length-1);
    }
    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }
     //Utility methods.
    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = (int) swap;
    }
    // is a[i] < a[j]?
    private static boolean less(int a, int b) {
        return a-b < 0;
    }

    // is a[i] < a[j]?
    private static boolean less(int a, int b, int comparator) {
        //return comparator(a < b) < 0;
        return a<b;
    }

     // Rearranges the array in ascending order, using the provided order.

    public static void sortX(int[] a, int comparator) {
        int[] aux = a.clone();
        sortX(aux, a, 0, a.length-1, comparator);
    }

    private static void merge(int[] src, int[] dst, int lo, int mid, int hi, int comparator) {
        // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                          dst[k] = src[j++];
            else if (j > hi)                           dst[k] = src[i++];
            else if (less(src[j], src[i], comparator)) dst[k] = src[j++];
            else                                       dst[k] = src[i++];
        }
    }
    private static void sortX(int[] src, int[] dst, int lo, int hi, int comparator) {
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi, comparator);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sortX(dst, src, lo, mid, comparator);
        sortX(dst, src, mid+1, hi, comparator);
        // using System.arraycopy() is a bit faster than the above loop
        if (!less(src[mid+1], src[mid], comparator)) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi, comparator);
    }

    // sort from a[lo] to a[hi] using insertion sort
    private static void insertionSort(int[] a, int lo, int hi, int comparator) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], comparator); j--)
                exch(a, j, j-1);
    }

     //Check if array is sorted - useful for debugging.
    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    // print array to standard output
    private static void show(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}




