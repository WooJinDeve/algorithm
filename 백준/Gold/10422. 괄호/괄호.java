import java.util.*;
public class Main {
    static long[] d = new long[5001];
    static long mod = 1000000007L;
    static long go(int n) {
        if (n == 0) {
            return 1;
        } else if (d[n] >= 0) {
            return d[n];
        }
        d[n] = 0;
        for (int i=2; i<=n; i+=2) {
            d[n] += go(i-2) * go(n-i);
            d[n] %= mod;
        }
        return d[n];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(d, -1);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n%2 == 0) {
                System.out.println(go(n));
            } else {
                System.out.println(0);
            }
        }
    }
}