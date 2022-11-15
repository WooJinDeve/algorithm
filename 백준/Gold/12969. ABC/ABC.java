import java.util.*;
public class Main {
    static boolean[][][][]d = new boolean[31][31][31][436];
    static char[] ans;
    static int n, k;
    static boolean go(int i, int a, int b, int p) {
        if (i == n) {
            if (p == k) return true;
            else return false;
        }
        if (d[i][a][b][p]) return false;
        d[i][a][b][p] = true;
        ans[i] = 'A';
        if (go(i+1, a+1, b, p)) return true;

        ans[i] = 'B';
        if (go(i+1, a, b+1, p+a)) return true;

        ans[i] = 'C';
        if (go(i+1, a, b, p+a+b)) return true;

        return false;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        ans = new char[n];
        if (go(0, 0, 0, 0)) {
            System.out.println(new String(ans));
        } else {
            System.out.println(-1);
        }
    }
}