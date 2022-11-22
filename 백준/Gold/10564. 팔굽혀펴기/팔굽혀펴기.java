import java.util.*;
public class Main {
    static boolean[][] d = new boolean[5001][5001];
    static int[] a = new int[10];
    static int n, m;
    static void go(int i, int j) {
        if (i > n) {
            return;
        }
        if (d[i][j]) return;
        d[i][j] = true;
        for (int k=0; k<m; k++) {
            go(i+j+a[k], j+a[k]);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i=0; i<m; i++) {
                a[i] = sc.nextInt();
            }
            for (int i=0; i<5001; i++) {
                Arrays.fill(d[i], false);
            }
            go(0, 0);
            int ans = -1;
            for (int i=1; i<=n; i++) {
                if (d[n][i]) {
                    ans = i;
                }
            }
            System.out.println(ans);
        }
    }
}