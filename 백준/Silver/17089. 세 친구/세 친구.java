import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] a = new boolean[n+1][n+1];
        int[] degree = new int[n+1];
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x][y] = a[y][x] = true;
            degree[x] += 1;
            degree[y] += 1;
        }
        int ans = -1;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (a[i][j]) {
                    for (int k=1; k<=n; k++) {
                        if (a[i][k] && a[j][k]) {
                            int sum = degree[i] + degree[j] + degree[k] - 6;
                            if (ans == -1 || ans > sum) {
                                ans = sum;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}