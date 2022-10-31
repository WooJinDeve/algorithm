import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] a = (List<Integer>[]) new List[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        int[] ind = new int[n+1];
        int[] work = new int[n+1];
        int[] d = new int[n+1];
        for (int i=1; i<=n; i++) {
            work[i] = sc.nextInt();
            int cnt = sc.nextInt();
            for (int j=0; j<cnt; j++) {
                int x = sc.nextInt();
                a[x].add(i);
                ind[i] += 1;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i=1; i<=n; i++) {
            if (ind[i] == 0) {
                q.add(i);
                d[i] = work[i];
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                ind[y] -= 1;
                if (d[y] < d[x]+work[y]) {
                    d[y] = d[x]+work[y];
                }
                if (ind[y] == 0) {
                    q.add(y);
                }
            }
        }
        int ans = 0;
        for (int i=1; i<=n; i++) {
            ans = Math.max(ans,d[i]);
        }
        System.out.println(ans);
    }
}