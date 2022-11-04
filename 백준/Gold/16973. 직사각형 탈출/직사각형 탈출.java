import java.util.*;
import java.io.*;
public class Main {
    static int[][] a;
    static int[][] d;
    static int[][] s;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int sum(int x1, int y1, int x2, int y2) {
        return s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1];
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        a = new int[n+1][m+1];
        d = new int[n+1][m+1];
        s = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            String[] row = bf.readLine().split(" ");
            for (int j=1; j<=m; j++) {
                a[i][j] = Integer.parseInt(row[j-1]);
                d[i][j] = -1;
            }
        }
        line = bf.readLine().split(" ");
        int h = Integer.parseInt(line[0]);
        int w = Integer.parseInt(line[1]);
        int x1 = Integer.parseInt(line[2]);
        int y1 = Integer.parseInt(line[3]);
        int x2 = Integer.parseInt(line[4]);
        int y2 = Integer.parseInt(line[5]);
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + a[i][j];
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(x1); q.add(y1);
        d[x1][y1] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (1 <= nx && nx+h-1 <= n && 1 <= ny && ny+w-1 <= m) {
                    if (sum(nx,ny,nx+h-1,ny+w-1) == 0) {
                        if (d[nx][ny] == -1) {
                            q.add(nx); q.add(ny);
                            d[nx][ny] = d[x][y] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(d[x2][y2]);
    }
}