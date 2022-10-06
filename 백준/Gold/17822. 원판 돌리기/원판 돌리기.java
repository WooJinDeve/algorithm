import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Main {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static void go(Integer[][] a, int x, int d, int k) {
        if (d == 0) {
            Collections.rotate(Arrays.asList(a[x]), k);
        } else {
            Collections.rotate(Arrays.asList(a[x]), (a[x].length-k));
        }
    }
    static boolean check(Integer[][] a) {
        int n = a.length-1;
        int m = a[1].length;
        boolean[][] d = new boolean[n+1][m];
        boolean ok = false; // 같은 수 있으면 true, 아니면 false
        // d[i][j] = true (같은 수), false: (같은 수 아님)
        for (int i=1; i<=n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j].intValue() == 0) continue;
                if (a[i][j].intValue() == a[i][(j+1)%m].intValue()) {
                    d[i][j] = d[i][(j+1)%m] = true;
                }
                if (i+1 <= n && a[i][j].intValue() == a[i+1][j].intValue()) {
                    d[i][j] = d[i+1][j] = true;
                }
            }
        }
        for (int i=1; i<=n; i++) {
            for (int j=0; j<m; j++) {
                if (d[i][j]) {
                    ok = true;
                    a[i][j] = 0;
                }
            }
        }
        return ok;
    }
    static void adjust(Integer[][] a) {
        int n = a.length-1;
        int m = a[1].length;
        long sum = 0;
        long cnt = 0;
        for (int i=1; i<=n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j].intValue() == 0) continue;
                sum += a[i][j];
                cnt += 1;
            }
        }
        if (cnt == 0L) return;
        for (int i=1; i<=n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j].intValue() == 0) continue;
                if (sum < (long)a[i][j].intValue()*cnt) {
                    // sum/cnt < a[i][j] (-1)
                    a[i][j] -= 1;
                } else if (sum > (long)a[i][j].intValue()*cnt) {
                    // sum/cnt > a[i][j] (+1)
                    a[i][j] += 1;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        Integer[][] a = new Integer[n+1][m];
        for (int i=1; i<=n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        while (t-- > 0) {
            int x = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();
            for (int y=x; y<=n; y+=x) {
                go(a, y, d, k);
            }
            boolean ok = check(a);
            if (ok == false) {
                adjust(a);
            }
        }
        int ans = 0;
        for (int i=1; i<=n; i++) {
            for (int j=0; j<m; j++) {
                ans += a[i][j].intValue();
            }
        }
        System.out.println(ans);
    }
}