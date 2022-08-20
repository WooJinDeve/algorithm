import java.util.*;
public class Main {
    static ArrayList<Integer>[] a;
    static ArrayList<Integer> dfs_order = new ArrayList<>();
    static boolean[] check;
    static void dfs(int x) {
        if (check[x]) return;
        dfs_order.add(x);
        check[x] = true;
        for (int y : a[x]) {
            dfs(y);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new ArrayList[n];
        check = new boolean[n];
        int[] b = new int[n];
        int[] order = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            a[u].add(v);
            a[v].add(u);
        }
        for (int i=0; i<n; i++) {
            b[i] = sc.nextInt()-1;
            order[b[i]] = i;
        }
        for (int i=0; i<n; i++) {
            Collections.sort(a[i], new Comparator<Integer>() {
                public int compare(Integer u, Integer v) {
                    if (order[u] < order[v]) {
                        return -1;
                    } else if (order[u] == order[v]) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });
        }
        dfs(0);
        boolean ok = true;
        for (int i=0; i<n; i++) {
            if (dfs_order.get(i) != b[i]) {
                ok = false;
            }
        }
        if (ok) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}