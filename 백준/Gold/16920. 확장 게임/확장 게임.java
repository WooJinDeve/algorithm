import java.util.*;
public class Main {
    final static int[] dx = {0,0,1,-1};
    final static int[] dy = {1,-1,0,0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] s = new int[p+1];
        for (int i=1; i<=p; i++) {
            s[i] = sc.nextInt();
        }
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            String line = sc.next();
            for (int j=0; j<m; j++) {
                char ch = line.charAt(j);
                if (ch == '.') {
                    a[i][j] = 0;
                } else if (ch == '#') {
                    a[i][j] = -1;
                } else {
                    a[i][j] = ch - '0';
                }
            }
        }
        Queue<Integer>[] q = new LinkedList[p+1];
        Queue<Integer>[] next_q = new LinkedList[p+1];
        for (int i=1; i<=p; i++) {
            q[i] = new LinkedList<Integer>();
            next_q[i] = new LinkedList<Integer>();
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] > 0) {
                    q[a[i][j]].add(i); q[a[i][j]].add(j);
                }
            }
        }
        while (true) {
            boolean ok = false;
            for (int who=1; who<=p; who++) {
                int[][] d = new int[n][m];
                while (!q[who].isEmpty()) {
                    ok = true;
                    int x = q[who].remove();
                    int y = q[who].remove();
                    if (d[x][y] == s[who]) {
                        next_q[who].add(x);
                        next_q[who].add(y);
                    }
                    if (a[x][y] > 0 && a[x][y] != who) {
                        continue;
                    }
                    a[x][y] = who;
                    for (int k=0; k<4; k++) {
                        int nx = x+dx[k];
                        int ny = y+dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            if (a[nx][ny] == 0) {
                                d[nx][ny] = d[x][y] + 1;
                                if (d[nx][ny] <= s[who]) {
                                    a[nx][ny] = who;
                                    q[who].add(nx);
                                    q[who].add(ny);
                                }
                            }
                        }
                    }
                }
                q[who] = next_q[who];
                next_q[who] = new LinkedList<Integer>();
            }
            if (!ok) {
                break;
            }
        }
        int[] ans = new int[p+1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] > 0) {
                    ans[a[i][j]] += 1;
                }
            }
        }
        for (int i=1; i<=p; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}