import java.util.*;
public class Main {
    static int n, m;
    static int[][] a;
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int bfs() {
        boolean[][] check = new boolean[n][m];
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 2 && check[i][j] == false) {
                    boolean dead = true;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i); q.add(j);
                    check[i][j] = true;
                    int cur = 0;
                    while (!q.isEmpty()) {
                        cur += 1;
                        int x = q.remove();
                        int y = q.remove();
                        for (int k=0; k<4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                                if (a[nx][ny] == 0) {
                                    dead = false;
                                } else if (a[nx][ny] == 2 && check[nx][ny] == false) {
                                    q.add(nx); q.add(ny);
                                    check[nx][ny] = true;
                                }
                            }
                        }
                    }
                    if (dead) {
                        ans += cur;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int x1=0; x1<n; x1++) {
            for (int y1=0; y1<m; y1++) {
                if (a[x1][y1] != 0) continue;
                for (int x2=0; x2<n; x2++) {
                    for (int y2=0; y2<m; y2++) {
                        if (x1==x2 && y1==y2) continue;
                        if (a[x2][y2] != 0) continue;
                        a[x1][y1] = 1;
                        a[x2][y2] = 1;
                        int cur = bfs();
                        if (ans < cur) {
                            ans = cur;
                        }
                        a[x1][y1] = 0;
                        a[x2][y2] = 0;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}