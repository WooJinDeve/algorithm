import java.util.*;

public class Main {
    public static final int MAX = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] c = new boolean[MAX];
        int[] d = new int[MAX];
        int[] cnt = new int[MAX];
        c[n] = true;
        d[n] = 0;
        cnt[n] = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : new int[]{now-1, now+1, now*2}) {
                if (next >= 0 && next < MAX) {
                    if (c[next] == false) {
                        q.add(next);
                        c[next] = true;
                        d[next] = d[now] + 1;
                        cnt[next] = cnt[now];
                    } else if (d[next] == d[now] + 1) {
                        cnt[next] += cnt[now];
                    }
                }
            }
        }
        System.out.println(d[m]);
        System.out.println(cnt[m]);
    }
}