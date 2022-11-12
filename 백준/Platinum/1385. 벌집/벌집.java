import java.util.*;
public class Main {
    static final int[] dx = {-1,0,1,1,0,-1};
    static final int[] dy = {1,1,0,-1,-1,0};
    static int[][] a = new int[2001][2001];
    static final int MAX = 3003001;
    static int[] coord_x = new int[MAX+1];
    static int[] coord_y = new int[MAX+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 1000;
        int y = 1000;
        a[x][y] = 1;
        int cur = 2;
        for (int level=1; level<=1000; level++) {
            x += dx[5];
            y += dy[5];
            a[x][y] = cur++;
            for (int k=0; k<6; k++) {
                int loop = level;
                if (k == 0) loop -= 1;
                for (int i=0; i<loop; i++) {
                    x += dx[k];
                    y += dy[k];
                    a[x][y] = cur++;
                }
            }
        }
        for (int i=0; i<=2000; i++) {
            for (int j=0; j<=2000; j++) {
                if (a[i][j] != 0 && a[i][j] <= MAX) {
                    coord_x[a[i][j]] = i;
                    coord_y[a[i][j]] = j;
                }
            }
        }
        int ed = sc.nextInt();
        int st = sc.nextInt();
        int[] dist = new int[MAX+1];
        Arrays.fill(dist, -1);
        int[] from = new int[MAX+1];
        Arrays.fill(from, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        dist[st] = 0;
        from[st] = -1;
        while (!q.isEmpty()) {
            int now = q.remove();
            x = coord_x[now];
            y = coord_y[now];
            for (int k=0; k<6; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx <= 2000 && 0 <= ny && ny <= 2000) {
                    if (a[nx][ny] != 0) {
                        int nxt = a[nx][ny];
                        if (dist[nxt] == -1) {
                            q.add(nxt);
                            dist[nxt] = dist[now] + 1;
                            from[nxt] = now;
                        }
                    }
                }
            }
        }
        System.out.print(ed + " ");
        while (st != ed) {
            ed = from[ed];
            System.out.print(ed + " ");
        }
    }
}