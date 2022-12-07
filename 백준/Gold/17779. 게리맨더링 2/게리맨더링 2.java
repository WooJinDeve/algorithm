import java.util.*;

public class Main {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static void bfs(int[][] d, int x, int y, int g) {
        int n = d.length;
        d[x][y] = g;
        Queue<Integer> q = new LinkedList<>();
        q.add(x); q.add(y);
        while (!q.isEmpty()) {
            x = q.remove();
            y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (d[nx][ny] == 0) {
                        d[nx][ny] = g;
                        q.add(nx); q.add(ny);
                    }
                }
            }
        }
    }
    static int go(int[][] a, int x, int y, int d1, int d2) {
        int n = a.length;
        int[][] d = new int[n][n];
        for (int i=0; i<=d1; i++) {
            d[x+i][y-i] = 5;
            d[x+d2+i][y+d2-i] = 5;
        }
        for (int i=0; i<=d2; i++) {
            d[x+i][y+i] = 5;
            d[x+d1+i][y-d1+i] = 5;
        }
        for (int j=0; j<y-d1; j++) {
            d[x+d1][j] = 3;
        }
        for (int i=0; i<x; i++) {
            d[i][y] = 1;
        }
        for (int j=y+d2+1; j<n; j++) {
            d[x+d2][j] = 2;
        }
        for (int i=x+d1+d2+1; i<n; i++) {
            d[i][y-d1+d2] = 4;
        }
        bfs(d, 0, 0, 1);
        bfs(d, 0, n-1, 2);
        bfs(d, n-1, 0, 3);
        bfs(d, n-1, n-1, 4);
        int[] cnt = new int[5];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (d[i][j] == 0) d[i][j] = 5;
                cnt[d[i][j]-1] += a[i][j];
            }
        }
        Arrays.sort(cnt);
        int ans = cnt[4] - cnt[0];
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = -1;
        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                for (int d1=1; d1<n; d1++) {
                    for (int d2=1; d2<n; d2++) {
                        if (0 <= y-d1 && y+d2 < n) {
                            if (x+d1+d2 < n) {
                                int temp = go(a, x, y, d1, d2);
                                if (ans == -1 || ans > temp) {
                                    ans = temp;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}