import java.util.*;
public class Main {
    static char[] group_to_color = new char[100];
    static int[] color_to_group = new int[256];
    static String tsort(boolean[][] g) {
        int n = g.length;
        int[] ind = new int[n];
        for (int i=0; i<n; i++) {
            boolean ok = true;
            for (int j=0; j<n; j++) {
                if (g[j][i]) {
                    ind[i] += 1;
                }
            }
        }
        String ans = "";
        PriorityQueue<Character> q = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            if (ind[i] == 0) {
                q.add(group_to_color[i]);
            }
        }
        while (!q.isEmpty()) {
            char ch = q.remove();
            ans += ch;
            int x = color_to_group[ch];
            for (int y=0; y<n; y++) {
                if (g[x][y]) {
                    ind[y] -= 1;
                    if (ind[y] == 0) {
                        q.add(group_to_color[y]);
                    }
                }
            }
        }
        if (ans.length() != n) {
            return "-1";
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        String[] a = new String[w];
        for (int i=0; i<w; i++) {
            a[i] = sc.next();
        }
        for (int i=0; i<256; i++) {
            color_to_group[i] = -1;
        }
        int n = 0;
        for (int i=0; i<w; i++) {
            for (int j=0; j<h; j++) {
                char ch = a[i].charAt(j);
                if (ch != '.') {
                    if (color_to_group[ch] == -1) {
                        color_to_group[ch] = n;
                        group_to_color[n] = ch;
                        n += 1;
                    }
                }
            }
        }
        boolean[][] g = new boolean[n][n];
        for (int k=0; k<n; k++) {
            int minx = w-1;
            int maxx = 0;
            int miny = h-1;
            int maxy = 0;
            for (int i=0; i<w; i++) {
                for (int j=0; j<h; j++) {
                    if (a[i].charAt(j) == group_to_color[k]) {
                        minx = Math.min(minx, i);
                        maxx = Math.max(maxx, i);
                        miny = Math.min(miny, j);
                        maxy = Math.max(maxy, j);
                    }
                }
            }
            for (int i=minx; i<=maxx; i++) {
                for (int j=miny; j<=maxy; j++) {
                    if (a[i].charAt(j) == '.') {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    if (a[i].charAt(j) != group_to_color[k]) {
                        g[k][color_to_group[a[i].charAt(j)]] = true;
                    }
                }
            }
        }
        String ans = tsort(g);
        System.out.println(ans);
    }
}