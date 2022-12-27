import java.util.*;
public class Main {
    static int calc(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int ans = 0;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<m-1; j++) {
                ans += a[i][j] + a[i][j+1] + a[i+1][j] + a[i+1][j+1];
            }
        }
        return ans;
    }
    static void swap_row(int[][] a, int r1, int r2) {
        int m = a[0].length;
        for (int j=0; j<m; j++) {
            int temp = a[r1][j];
            a[r1][j] = a[r2][j];
            a[r2][j] = temp;
        }
    }
    static void swap_col(int[][] a, int c1, int c2) {
        int n = a.length;
        for (int i=0; i<n; i++) {
            int temp = a[i][c1];
            a[i][c1] = a[i][c2];
            a[i][c2] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = calc(a);
        for (int i=1; i<n-1; i++) {
            swap_row(a, 0, i);
            int temp = calc(a);
            if (ans < temp) ans = temp;
            swap_row(a, 0, i);
            swap_row(a, n-1, i);
            int temp2 = calc(a);
            if (ans < temp2) ans = temp2;
            swap_row(a, n-1, i);
        }
        for (int j=1; j<m-1; j++) {
            swap_col(a, 0, j);
            int temp = calc(a);
            if (ans < temp) ans = temp;
            swap_col(a, 0, j);
            swap_col(a, m-1, j);
            int temp2 = calc(a);
            if (ans < temp2) ans = temp2;
            swap_col(a, m-1, j);
        }
        System.out.println(ans);
    }
}