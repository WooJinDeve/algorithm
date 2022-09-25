import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        a = " " + a;
        b = " " + b;
        int[][] d = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    d[i][j] = d[i-1][j-1] + 1;
                } else {
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }
        System.out.println(d[n][m]);
    }
}