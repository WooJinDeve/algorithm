import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int[] d = new int[m+1];
        for (int i=0; i<=m; i++) {
            d[i] = -1;
        }
        d[0] = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=m; j++) {
                if (j-a[i] >= 0 && d[j-a[i]] != -1) {
                    if (d[j] == -1 || d[j] > d[j-a[i]]+1) {
                        d[j] = d[j-a[i]] + 1;
                    }
                }
            }
        }
        System.out.println(d[m]);
    }
}