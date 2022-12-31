import java.util.*;
public class Main {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int[][] rotate(int[][] a) {
        int n = a.length;
        int[][] ans = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                ans[i][j] = a[n-j-1][i];
            }
        }
        return ans;
    }
    static void firestorm(int[][] a, int sx, int sy, int size) {
        int[][] b = new int[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                b[i][j] = a[sx+i][sy+j];
            }
        }
        b = rotate(b);
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                a[sx+i][sy+j] = b[i][j];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int m = (1 << n);
        int[][] a = new int[m][m];
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        while (q-- > 0) {
            int l = sc.nextInt();
            if (l > 0) {
                int size = (1<<l);
                for (int sx=0; sx<m; sx+=size) {
                    for (int sy=0; sy<m; sy+=size) {
                        firestorm(a, sx, sy, size);
                    }
                }
            }
            int[][] b = new int[m][];
            for (int i=0; i<m; i++) {
                b[i] = a[i].clone();
            }
            for (int i=0; i<m; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i][j] == 0) continue;
                    int cnt = 0;
                    for (int k=0; k<4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if (0 <= nx && nx < m && 0 <= ny && ny < m) {
                            if (b[nx][ny] > 0) {
                                cnt += 1;
                            }
                        }
                    }
                    if (cnt >= 3) {
                    } else {
                        if (a[i][j] > 0) {
                            a[i][j] -= 1;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                ans += a[i][j];
            }
        }
        System.out.println(ans);
        boolean[][] check = new boolean[m][m];
        ans = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0) continue;
                if (check[i][j] == true) continue;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i); queue.add(j);
                int cnt = 1;
                check[i][j] = true;
                while (!queue.isEmpty()) {
                    int x = queue.remove();
                    int y = queue.remove();
                    for (int k=0; k<4; k++) {
                        int nx = x+dx[k];
                        int ny = y+dy[k];
                        if (0 <= nx && nx < m && 0 <= ny && ny < m) {
                            if (a[nx][ny] != 0 && check[nx][ny] == false) {
                                check[nx][ny] = true;
                                queue.add(nx); queue.add(ny);
                                cnt += 1;
                            }
                        }
                    }
                }
                if (ans < cnt) ans = cnt;
            }
        }
        System.out.println(ans);
    }
}