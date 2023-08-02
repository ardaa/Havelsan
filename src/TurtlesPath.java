
import java.util.*;


public class TurtlesPath {

    int M;
    int N;

    public TurtlesPath(int M, int N) {
        this.M = M;
        this.N = N;
    }

    public int countPaths(int[][] table) {
        int[][] path = new int[M][N];
        path[0][0] = 1;
        for (int i = 1; i < M; i++) {
            if (isPrime(table[i][0])) {
                path[i][0] = path[i - 1][0];
            }
        }
        for (int i = 1; i < N; i++) {
            if (isPrime(table[0][i])) {
                path[0][i] = path[0][i - 1];
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (isPrime(table[i][j])) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1] + path[i - 1][j - 1];
                }
            }
        }
        return path[M - 1][N - 1];
    }

    //print the lexicographically largest path

    public void printPath(int[][] table) {
        int[][] path = new int[M][N];
        path[0][0] = 1;
        for (int i = 1; i < M; i++) {
            if (isPrime(table[i][0])) {
                path[i][0] = path[i - 1][0];
            }
        }
        for (int i = 1; i < N; i++) {
            if (isPrime(table[0][i])) {
                path[0][i] = path[0][i - 1];
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (isPrime(table[i][j])) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1] + path[i - 1][j - 1];
                }
            }
        }

        int i = 0;
        int j = 0;
        while (i < M && j < N) {
            System.out.println((i + 1) + " " + (j + 1));
            if (i == M - 1) {
                j++;
            } else if (j == N - 1) {
                i++;
            } else {
                if (path[i + 1][j] > path[i][j + 1]) {
                    i++;
                } else if (path[i + 1][j] < path[i][j + 1]) {
                    j++;
                } else {
                    if (isPrime(table[i + 1][j + 1])) {
                        i++;
                        j++;
                    } else {
                        i++;
                    }
                }
            }
        }

    }


    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n) + 1;
        for (int i = 6; i <= sqrt; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] table = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                table[i][j] = scanner.nextInt();
            }
        }
        TurtlesPath turtlesPath = new TurtlesPath(M, N);
        int count = turtlesPath.countPaths(table);
        System.out.println(count);
        if (count > 0) {
            turtlesPath.printPath(table);
        }
    }

}