import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dist = new int[500001][2];
        for (int i=0; i<=500000; i++) {
            dist[i][0] = dist[i][1] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(n); q.add(0);
        dist[n][0] = 0;
        while (!q.isEmpty()) {
            int x = q.remove();
            int t = q.remove();
            for (int y : new int[]{x+1, x-1, 2*x}) {
                if (0 <= y && y <= 500000) {
                    if (dist[y][1-t] == -1) {
                        dist[y][1-t] = dist[x][t] + 1;
                        q.add(y); q.add(1-t);
                    }
                }
            }
        }
        int ans = -1;
        for (int t=0;; t++) {
            k += t;
            if (k > 500000) break;
            if (dist[k][t%2] <= t) {
                ans = t;
                break;
            }
        }
        System.out.println(ans);
    }
}