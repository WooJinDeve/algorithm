import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n+1];
        boolean[][] d = new boolean[n+1][m+1];
        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }
        d[0][s] = true;
        for (int i=0; i<=n-1; i++) {
            for (int j=0; j<=m; j++) {
                if (d[i][j] == false) {
                    continue;
                }
                if (j-a[i+1] >= 0) {
                    d[i+1][j-a[i+1]] = true;
                }
                if (j+a[i+1] <= m) {
                    d[i+1][j+a[i+1]] = true;
                }
            }
        }
        int ans = -1;
        for (int i=0; i<=m; i++) {
            if (d[n][i]) ans = i;
        }
        System.out.println(ans);
    }
}