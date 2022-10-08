import java.util.*;
public class Main {
    static long[] d;
    static long[] p;
    static long go(int n, long x) {
        if (n == 0) {
            if (x == 0) {
                return 0;
            } else {
                return 1;
            }
        } else if (x == 1) {
            return 0;
        } else if (x <= 1 + d[n-1]) {
            return go(n-1, x-1);
        } else if (x == 1 + d[n-1] + 1) {
            return p[n-1] + 1;
        } else if (x <= 1 + d[n-1] + 1 + d[n-1]) {
            return p[n-1] + 1 + go(n-1, x-1-d[n-1]-1);
        } else {
            return p[n-1] + 1 + p[n-1];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n+1];
        p = new long[n+1];
        long x = sc.nextLong();
        d[0] = 1;
        p[0] = 1;
        for (int i=1; i<=n; i++) {
            d[i] = 1 + d[i-1] + 1 + d[i-1] + 1;
            p[i] = p[i-1] + 1 + p[i-1];
        }
        System.out.println(go(n, x));
    }
}