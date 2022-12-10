import java.util.*;
public class Main {
    static int[][] a;
    static int n;
    static int go(int x, int y, int dir) {
        if (x == n-1 && y == n-1) {
            return 1;
        }
        int ans = 0;
        if (dir == 0) { // -
            if (y+1 < n && a[x][y+1] == 0) {
                ans += go(x, y+1, 0);
            }
            if (x+1 < n && y+1 < n && a[x][y+1] == 0 && a[x+1][y] == 0 && a[x+1][y+1] == 0) {
                ans += go(x+1, y+1, 1);
            }
        } else if (dir == 1) { // dig
            if (y+1 < n && a[x][y+1] == 0) {
                ans += go(x, y+1, 0);
            }
            if (x+1 < n && a[x+1][y] == 0) {
                ans += go(x+1, y, 2);
            }
            if (x+1 < n && y+1 < n && a[x][y+1] == 0 && a[x+1][y] == 0 && a[x+1][y+1] == 0) {
                ans += go(x+1, y+1, 1);
            }
        } else if (dir == 2) { // |
            if (x+1 < n && a[x+1][y] == 0) {
                ans += go(x+1, y, 2);
            }
            if (x+1 < n && y+1 < n && a[x][y+1] == 0 && a[x+1][y] == 0 && a[x+1][y+1] == 0) {
                ans += go(x+1, y+1, 1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(go(0, 1, 0));
    }
}
