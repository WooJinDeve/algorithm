import java.util.*;
public class Main {
    static int[][] d = new int[301][301];
    static int go(int n, int m) {
        if (n == 1 && m == 1) {
            return 0;
        }
        int ans = d[n][m];
        if (ans != -1) {
            return ans;
        }
        ans = 1000000000;
        for (int i=1; i<n; i++) {
            if (ans > go(i, m) + go(n-i, m) + 1) {
                ans = go(i, m) + go(n-i, m) + 1;
            }
        }
        for (int i=1; i<m; i++) {
            if (ans > go(n, i) + go(n, m-i) + 1) {
                ans = go(n, i) + go(n, m-i) + 1;
            }
        }
        d[n][m] = ans;
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i=0; i<301; i++) {
            Arrays.fill(d[i], -1);
        }
        System.out.println(go(n, m));
    }
}
