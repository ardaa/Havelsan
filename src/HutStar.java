import java.util.*;

public class HutStar {
    static void hutPrinter(int n)
    {
        //triangle
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (2*i + 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        //hut
        for (int i = 0; i < 3; i++) {

            //left
            for (int j = 0; j < 3; j++)
                System.out.print("*");

            //door
            for (int j = 0; j < (2*n-7); j++)
                System.out.print(" ");

            //right
            for (int j = 0; j < 3; j++)
                System.out.print("*");

            System.out.println();
        }
    }
    public static void main(String[] args)
    {

        int n = 0;
        while (n < 3) {
            System.out.println("n=");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

        }

        hutPrinter(n);
    }



}
