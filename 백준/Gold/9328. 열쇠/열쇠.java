import java.util.*;
public class Main {
    static char[][] a = new char[111][111];
    static boolean[][] c = new boolean[111][111];
    static boolean[] key = new boolean[111];
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i=0; i<111; i++) {
                for (int j=0; j<111; j++) {
                    a[i][j] = 0;
                }
            }
            for (int i=2; i<n+2; i++) {
                String line = sc.next();
                for (int j=0; j<m; j++) {
                    a[i][j+2] = line.charAt(j);
                }
            }
            n += 4;
            m += 4;
            for (int i=0; i<n; i++) {
                a[i][0] = '*';
                a[i][1] = '.';
                a[i][m-2] = '.';
                a[i][m-1] = '*';
            }
            for (int j=1; j<m-1; j++) {
                a[0][j] = '*';
                a[1][j] = '.';
                a[n-2][j] = '.';
                a[n-1][j] = '*';
            }
            Arrays.fill(key, false);
            String temp = sc.next();
            int len = temp.length();
            if (temp.charAt(0) != '0') {
                for (int i=0; i<len; i++) {
                    key[temp.charAt(i)-'a'] = true;
                }
            }
            int ans = 0;
            for (int i=0; i<111; i++) {
                Arrays.fill(c[i], false);
            }
            Queue<Integer> q = new LinkedList<>();
            Queue<Integer>[] door = new LinkedList[26];
            for (int i=0; i<26; i++) {
                door[i] = new LinkedList<Integer>();
            }
            q.add(1); q.add(1);
            c[1][1] = true;
            while (!q.isEmpty()) {
                int x = q.remove();
                int y = q.remove();
                for (int k=0; k<4; k++) {
                    int nx = x+dx[k];
                    int ny = y+dy[k];
                    if (c[nx][ny]) {
                        continue;
                    }
                    char w = a[nx][ny];
                    if (w == '*') {
                        continue;
                    }
                    c[nx][ny] = true;
                    if (w == '.') {
                        q.add(nx); q.add(ny);
                    } else if (w == '$') {
                        ans += 1;
                        q.add(nx); q.add(ny);
                    } else if (w >= 'A' && w <= 'Z') {
                        if (key[w-'A']) {
                            q.add(nx); q.add(ny);
                        } else {
                            door[w-'A'].add(nx);
                            door[w-'A'].add(ny);
                        }
                    } else if (w >= 'a' && w <= 'z') {
                        q.add(nx); q.add(ny);
                        if (!key[w-'a']) {
                            key[w-'a'] = true;
                            while (!door[w-'a'].isEmpty()) {
                                q.add(door[w-'a'].remove());
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}