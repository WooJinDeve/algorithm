import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] a = (List<Integer>[]) new List[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        int[] ind = new int[n+1];
        for (int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x].add(y);
            ind[y] += 1;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i=1; i<=n; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.remove();
            System.out.print(x + " ");
            for (int y : a[x]) {
                ind[y] -= 1;
                if (ind[y] == 0) {
                    q.add(y);
                }
            }
        }
        System.out.println();
    }
}