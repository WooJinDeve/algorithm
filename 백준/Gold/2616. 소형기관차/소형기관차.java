import java.util.*;
public class Main {
    static int[] s = new int [50001];
    static int[] a = new int [50001];
    static int[][] d = new int [50001][4];
    static int sum(int x, int y) {
        return s[y] - s[x-1];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i-1] + a[i];
        }
        int m = sc.nextInt();
        for (int j=1; j<=3; j++) {
            for (int i=m*j; i<=n; i++) {
                d[i][j] = d[i-1][j];
                d[i][j] = Math.max(d[i][j], d[i-m][j-1] + sum(i-m+1, i));
            }
        }
        System.out.println(d[n][3]);
    }
}