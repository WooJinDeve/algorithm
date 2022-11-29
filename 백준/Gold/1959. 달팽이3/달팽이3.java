import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long d = (Math.min(n, m) - 1) / 2;
        long ans = 4*d;
        long row = 1+d;
        long col = 1+d;
        n -= 2*d;
        m -= 2*d;
        
        if (n == 1) {
            col += (m - 1);
        } else if (m == 1) {
            ans += 1;
            row += (n - 1);
        } else if (n == 2) {
            ans += 2;
            row += 1;
        } else {
            ans += 3;
            row += 1;
        }
        System.out.println(ans);
        System.out.println(row + " " + col);
    }
}