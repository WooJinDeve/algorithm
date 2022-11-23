import java.util.*;
public class Main {
    static long[][] d = new long[21][21];
    static long gcd(long x, long y) {
        if (y == 0) return x;
        else return gcd(y, x%y);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        d[1][1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                d[i][j] = d[i-1][j-1] + (i-1) * d[i-1][j];
            }
        }
        long bunja = 0;
        for (int i=1; i<=m; i++) {
            bunja += d[n][i];
        }
        long bunmo = 1;
        for (int i=1; i<=n; i++) {
            bunmo *= i;
        }
        long g = gcd(bunja, bunmo);
        bunja /= g;
        bunmo /= g;
        System.out.printf("%d/%d\n",bunja,bunmo);
    }
}