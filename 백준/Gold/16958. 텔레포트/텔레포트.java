import java.util.*;
public class Main {
    static int n, t;
    static int[] x;
    static int[] y;
    static int[] s;
    static int[][] dist;
    static int manhattan(int i, int j) {
        int t1 = x[i] - x[j];
        int t2 = y[i] - y[j];
        if (t1 < 0) t1 = -t1;
        if (t2 < 0) t2 = -t2;
        return t1 + t2;
    }
    static int near(int u) {
        int ans = -1;
        int where = -1;
        for (int i=0; i<n; i++) {
            if (s[i] == 0) continue;
            if (ans == -1 || ans > dist[u][i]) {
                ans = dist[u][i];
                where = i;
            }
        }
        return where;
    }
    static int calc(int u, int v) {
        int ans = dist[u][v];
        if (s[u] == 1 && s[v] == 1) {
            if (ans > t) ans = t;
        }
        int us = near(u);
        int vs = near(v);
        if (us != -1 && vs != -1 && s[us] == 1 && s[vs] == 1) {
            int temp = dist[u][us] + t + dist[vs][v];
            if (ans > temp) ans = temp;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        x = new int[n];
        y = new int[n];
        s = new int[n];
        dist = new int[n][n];
        for (int i=0; i<n; i++) {
            s[i] = sc.nextInt();
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                dist[i][j] = dist[j][i] = manhattan(i, j);
            }
        }
        int m = sc.nextInt();
        while (m-- > 0) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            System.out.println(calc(u, v));
        }
    }
}