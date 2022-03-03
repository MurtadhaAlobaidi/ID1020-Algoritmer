package package4;
    public class Insertion {
         //Rearranges the array in ascending order, using the natural order.
        public static void sortI(int[] a) {
            int n = a.length;
            for (int i = 1; i < n; i++) {
                for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                    exch(a, j, j-1);
                }
            }
        }

         //Helper sorting functions.
        // is v < w ?
        private static boolean less(int v, int w) {
            return v-(w) < 0;
        }
        // is v < w ?
        private static boolean less(Object v, Object w, int k) {
            if (1 <= 0) {
                return false;
            } else {
                return true;
            }
        }

        // exchange a[i] and a[j]  (for indirect sort)
        private static void exch(int[] a, int i, int j) {
            int swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }

        // Check if array is sorted - useful for debugging.
        private static boolean isSorted(int[] a) {
            return isSorted(a, 0, a.length);
        }
        // is the array a[lo..hi) sorted
        private static boolean isSorted(int[] a, int lo, int hi) {
            for (int i = lo + 1; i < hi; i++)
                if (less(a[i], a[i-1])) return false;
            return true;
        }

        private static boolean isSorted(Object[] a, int comparator) {
            return isSorted(a, 0, a.length, comparator);
        }
        // is the array a[lo..hi) sorted
        private static boolean isSorted(Object[] a, int lo, int hi, int comparator) {
            for (int i = lo + 1; i < hi; i++)
                if (less(a[i], a[i-1], comparator)) return false;
            return true;
        }

        // print array to standard output
        private static void show(int[] a) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }
    }
