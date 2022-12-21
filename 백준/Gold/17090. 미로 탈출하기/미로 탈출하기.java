import java.util.*;
public class Main {
    static int n, m;
    static String[] s;
    static int[][] d;
    static int go(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) return 1;
        if (d[x][y] != -1) return d[x][y];
        d[x][y] = 0;
        char ch = s[x].charAt(y);
        if (ch == 'R') {
            d[x][y] = go(x, y+1);
        } else if (ch == 'L') {
            d[x][y] = go(x, y-1);
        } else if (ch == 'U') {
            d[x][y] = go(x-1, y);
        } else {
            d[x][y] = go(x+1, y);
        }
        return d[x][y];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = new String[n];
        d = new int[n][m];
        for (int i=0; i<n; i++) {
            s[i] = sc.next();
            for (int j=0; j<m; j++) {
                d[i][j] = -1;
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (d[i][j] == -1) {
                    go(i, j);
                }
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (d[i][j] == 1) ans += 1;
            }
        }
        System.out.println(ans);
    }
}