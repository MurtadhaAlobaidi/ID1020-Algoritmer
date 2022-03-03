package package1;

public class Insertinonsort1 {
    //För att sotera elemenar
    public static void sortIA1(int[] a) {
        int n = a.length;
        int countSwap = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                countSwap++;
                System.out.println("[" + "swap" + countSwap + "]");
                exch(a, j, j - 1);
            }
        }
    }
    //Jämföra och kolla om första element mindre
    private static boolean less(int v, int w) {
        return v - (w) < 0;
    }

    //För att swap mellan element
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;

        show(a);//print swapen
    }

    // print array to standard output
    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" +a[i]+ "]" + " ");
        }
        System.out.println();
    }
}
