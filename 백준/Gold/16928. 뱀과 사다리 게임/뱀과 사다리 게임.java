import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dist = new int[101];
        int[] next = new int[101];
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i=1; i<=100; i++) {
            next[i] = i;
            dist[i] = -1;
        }
        for (int k=0; k<n+m; k++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            next[x] = y;
        }
        dist[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int i=1; i<=6; i++) {
                int y = x+i;
                if (y > 100) continue;
                y = next[y];
                if (dist[y] == -1) {
                    dist[y] = dist[x] + 1;
                    q.add(y);
                }
            }
        }
        System.out.println(dist[100]);
    }
}