import java.util.*;
public class Main {
    static int[][] b;
    static int n, m, d;
    static int calc(int l1, int l2, int l3) {
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = b[i][j];
            }
        }
        int ans = 0;
        while (true) {
            int cnt = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    cnt += a[i][j];
                }
            }
            if (cnt == 0) break;
            int[][] deleted = new int[3][2];
            for (int i=0; i<3; i++) {
                deleted[i][0] = deleted[i][1] = -1;
            }
            int[] robot = {l1, l2, l3};
            for (int k=0; k<3; k++) {
                int rx = n, ry = robot[k];
                int x, y, dist;
                x = y = dist = -1;
                for (int j=0; j<m; j++) {
                    for (int i=0; i<n; i++) {
                        if (a[i][j] != 0) {
                            int dx = Math.abs(rx-i);
                            int dy = Math.abs(ry-j);
                            int dd = dx+dy;
                            if (dd <= d) {
                                if (dist == -1 || dist > dd) {
                                    x = i;
                                    y = j;
                                    dist = dd;
                                }
                            }
                        }
                    }
                }
                deleted[k][0] = x;
                deleted[k][1] = y;
            }
            for (int i=0; i<3; i++) {
                int x = deleted[i][0];
                int y = deleted[i][1];
                if (x == -1) continue;
                if (a[x][y] != 0) {
                    ans += 1;
                }
                a[x][y] = 0;
            }
            for (int i=n-1; i>=0; i--) {
                for (int j=0; j<m; j++) {
                    if (i == 0) {
                        a[i][j] = 0;
                    } else {
                        a[i][j] = a[i-1][j];
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
        d = sc.nextInt();
        b = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int l1=0; l1<m; l1++) {
            for (int l2=l1+1; l2<m; l2++) {
                for (int l3=l2+1; l3<m; l3++) {
                    int temp = calc(l1,l2,l3);
                    if (ans < temp) ans = temp;
                }
            }
        }
        System.out.println(ans);
    }
}