import java.util.*;
public class Main {
    static long[][] d = new long[100][21];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n -= 1;
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int goal = sc.nextInt();
        d[0][a[0]] = 1;
        for (int i=1; i<n; i++) {
            for (int j=0; j<=20; j++) {
                if (j-a[i] >= 0) {
                    d[i][j] += d[i-1][j-a[i]];
                }
                if (j+a[i] <= 20) {
                    d[i][j] += d[i-1][j+a[i]];
                }
            }
        }
        System.out.println(d[n-1][goal]);
    }
}
