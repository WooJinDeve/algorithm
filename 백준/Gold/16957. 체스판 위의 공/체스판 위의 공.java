import java.util.*;
public class Main {
    static int[] parent;
    static final int[] dx = {0,0,1,-1,1,1,-1,-1};
    static final int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int go(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = go(parent[x]);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        parent = new int[n*m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int x = i;
                int y = j;
                for (int k=0; k<8; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m)
                        if (a[nx][ny] < a[x][y]) {
                            x = nx;
                            y = ny;
                        }
                }
                parent[i*m+j] = x*m+y;
            }
        }
        int[] ans = new int[n*m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                ans[go(i*m+j)] += 1;
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(ans[i*m+j] + " ");
            }
            System.out.println();
        }
    }
}