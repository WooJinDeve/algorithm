import java.util.*;
public class Main {
    static int[][] a, b;
    static int n, m;
    static final int[] dx = {0,-1,0,1};
    static final int[] dy = {1,0,-1,0};
    static void go(int sx, int sy, int z) {
        int prev = 0;
        int x = sx;
        int y = sy+1;
        int k = 0;
        while (true) {
            if (x == sx && y == sy) break;
            int temp = prev;
            prev = a[x][y];
            a[x][y] = temp;
            x += dx[k];
            y += dy[k];
            if (x < 0 || y < 0 || x >= n || y >= m) {
                x -= dx[k];
                y -= dy[k];
                k += z;
                k %= 4;
                x += dx[k];
                y += dy[k];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        b = new int[n][m];
        int t = sc.nextInt();
        int x=0,y=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == -1) {
                    x = i;
                    y = j;
                }
            }
        }
        x -= 1;
        while (t-- > 0) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i][j] <= 0) continue;
                    int cnt = 0;
                    for (int k=0; k<4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && a[nx][ny] >= 0) {
                            cnt += 1;
                        }
                    }
                    if (cnt > 0) {
                        int val = a[i][j]/5;
                        for (int k=0; k<4; k++) {
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m && a[nx][ny] >= 0) {
                                b[nx][ny] += val;
                            }
                        }
                        a[i][j] = a[i][j] - cnt*val;
                    }
                }
            }
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i][j] == -1) continue;
                    a[i][j] += b[i][j];
                    b[i][j] = 0;
                }
            }
            go(x,y,1);
            go(x+1,y,3);
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] >= 0) {
                    ans += a[i][j];
                }
            }
        }
        System.out.println(ans);
    }
}