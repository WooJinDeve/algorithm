import java.util.*;

public class Main {
    public static final long mod = 1000000007;
    public static int n, m, p;
    public static long[][] d = new long[101][101];
    public static long go(int position, int x) {
        int y = n-x;
        if (position == p) {
            if (y == 0) return 1; else return 0;
        }
        long ans = d[position][x];
        if (ans != -1) {
            return ans;
        }
        ans = 0;
        if (y > 0) {
            ans += go(position+1, x+1) * y;
        }
        if (x > m) {
            ans += go(position+1, x) * (x-m);
        }
        ans %= mod;
        d[position][x] = ans;
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();
        for (int i=0; i<101; i++) {
            for (int j=0; j<101; j++) {
                d[i][j] = -1;
            }
        }
        System.out.println(go(0,0));
    }
}