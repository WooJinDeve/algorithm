import java.util.*;

public class Main {
    static int[][] a;
    static int[][] d;
    public static int go(int i, int j) {
        if (d[i][j] > 0) {
            return d[i][j];
        }
        if (i == j) {
            return 0;
        }
        if (i+1 == j) {
            return a[i][0]*a[i][1]*a[j][1];
        }
        d[i][j] = -1;
        for (int k=i; k<j; k++) {
            int t1 = go(i,k);
            int t2 = go(k+1,j);
            int t3 = a[i][0]*a[k][1]*a[j][1];
            if (d[i][j] == -1 || d[i][j] > t1+t2+t3) {
                d[i][j] = t1+t2+t3;
            }
        }
        return d[i][j];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n][2];
        for (int i=0; i<n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        d = new int[n][n];
        System.out.println(go(0,n-1));
    }
}