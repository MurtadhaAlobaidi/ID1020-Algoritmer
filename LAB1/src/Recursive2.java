import java.util.Scanner;

public class Recursive2
{
    public static void main(String[] args)
    {
        // Deklarera objektet och initiera med
        // för definierat standard inmatningsobjekt
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Input:");
        // Character input
        String c = sc.nextLine();
        //listen
        char a[]=c.toCharArray();
        System.out.println("Input are:");
        //för att längden ska vara obegränsade
        int m =a.length-1;
        //calla upp mathoden satt som har a liste i m lista
        satt(a,m);
    }

    public static void satt(char L [] , int b)
    {
        if (b>=0)
        {
            //Skriva upp Char listen och fylla på den omvänd
            System.out.print(L[b--]);
            //return till funcktionen
            satt (L, b);
        }
    }
}
