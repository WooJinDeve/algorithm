import java.util.*;
public class Main {
    static final int n = 5;
    static final int[] dx = {0,0,0,0,1,-1};
    static final int[] dy = {0,0,1,-1,0,0};
    static final int[] dz = {1,-1,0,0,0,0};
    static int bfs(int[][][] a) {
        if (a[0][0][0] == 0) return -1;
        int[][][] dist = new int[n][n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0); q.add(0); q.add(0);
        dist[0][0][0] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int z = q.remove();
            for (int k=0; k<6; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                int nz = z+dz[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && 0 <= nz && nz < n) {
                    if (a[nx][ny][nz] == 1 && dist[nx][ny][nz] == -1) {
                        dist[nx][ny][nz] = dist[x][y][z] + 1;
                        q.add(nx); q.add(ny); q.add(nz);
                    }
                }
            }
        }
        return dist[n-1][n-1][n-1];
    }
    static int[][] clockwise(int[][] a) {
        int[][] b = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                b[i][j] = a[n-j-1][i];
            }
        }
        return b;
    }
    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] a = new int[n][n][n];
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    a[k][i][j] = sc.nextInt();
                }
            }
        }
        int[] order = new int[n];
        for (int i=0; i<n; i++) {
            order[i] = i;
        }
        int ans = -1;
        do {
            int[][][] b = new int[n][n][n];
            for (int i=0; i<n; i++) {
                b[order[i]] = a[i];
            }
            for (int l1=0; l1<4; l1++) {
                for (int l2=0; l2<4; l2++) {
                    for (int l3=0; l3<4; l3++) {
                        for (int l4=0; l4<4; l4++) {
                            for (int l5=0; l5<4; l5++) {
                                int cur = bfs(b);
                                if (cur != -1) {
                                    if (ans == -1 || ans > cur) {
                                        ans = cur;
                                    }
                                }
                                b[4] = clockwise(b[4]);
                            }
                            b[3] = clockwise(b[3]);
                        }
                        b[2] = clockwise(b[2]);
                    }
                    b[1] = clockwise(b[1]);
                }
                b[0] = clockwise(b[0]);
            }
        } while (next_permutation(order));
        System.out.println(ans);
    }
}