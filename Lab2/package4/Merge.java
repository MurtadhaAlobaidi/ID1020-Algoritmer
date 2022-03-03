package package4;
import java.util.Scanner;
public class Merge {
    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // copy to aux[] till extra array
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; //den ta från nya array till ny lista halv från merge
        }
        // merge back to a[]
        int i = lo, j = mid+1; //i=lo
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++]; //Den första halava array (höger)
            else if (j > hi)               a[k] = aux[i++];//Den andra halava nytt array(vänster) ej funka först
            else if (less(aux[j], aux[i])) a[k] = aux[j++];//vilken är mindre aux[j] < aux[i] sätta den först den + och första för hela lista igen
            else                           a[k] = aux[i++];//lo den stämmer när den mindre
        }
        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sortM(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sortM(a, aux, lo, mid);
        sortM(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    //Rearranges the array in ascending order, using the natural order.
    public static void sortM(int[] a) {
        int[] aux = new int[a.length];
        sortM(a, aux, 0, a.length-1);
    }

    //Helper sorting function.
    // is v < w ?
    private static boolean less(int v, int w) {
        return v-w < 0;
    }

    //Check if array is sorted - useful for debugging.
    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    /**
     * Returns a permutation that gives the elements in the array in ascending order.
     * @param a the array
     * @return a permutation {@code p[]} such that {@code a[p[0]]}, {@code a[p[1]]},
     *    ..., {@code a[p[N-1]]} are in ascending order
     */
    public static int[] indexSort(int[] a) {
        int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;

        int[] aux = new int[n];
        sortM(a, index, aux, 0, n-1);
        return index;
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sortM(int[] a, int[] index, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sortM(a, index, aux, lo, mid);
        sortM(a, index, aux, mid + 1, hi);
       // merge(a, index, aux, lo, mid, hi);
    }

    // print array to standard output
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
