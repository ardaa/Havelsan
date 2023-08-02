import java.util.*;


public class TwoStacks {
    //play
    static int play(int[] stackA, int[] stackB, int x) {
        int max = 0;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (i < stackA.length && sum + stackA[i] <= x) {
            sum += stackA[i];
            i++;
        }
        max = i;
        while (j < stackB.length && i < stackA.length) {
            sum += stackB[j];
            j++;
            while (sum > x && i > 0) {
                i--;
                sum -= stackA[i];
            }
            if (sum <= x && i + j > max) {
                max = i + j;
            }
        }
        return max;
    }
    //main
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for (int a0 = 0; a0 < g; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            System.out.println(play(a, b, x));
        }
    }
}
