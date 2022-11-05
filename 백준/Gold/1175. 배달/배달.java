import java.util.*;
class Pair {
    int x, y, dir, s;
    Pair(int x, int y,int dir, int s) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.s = s;
    }
}
public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][][][] d = new int[51][51][4][4];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][];
        sc.nextLine();
        for (int i=0; i<n; i++) {
            a[i] = sc.nextLine().toCharArray();
        }
        int ans = -1;
        int x1,y1,x2,y2;
        x1 = y1 = x2 = y2 = -1;
        for (int i=0; i<51; i++) {
            for (int j=0; j<51; j++) {
                for (int k=0; k<4; k++) {
                    for (int l=0; l<4; l++) {
                        d[i][j][k][l] = -1;
                    }
                }
            }
        }
        Queue<Pair> q = new LinkedList<Pair>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 'S') {
                    for (int k=0; k<4; k++) {
                        q.add(new Pair(i,j,k,0));
                        d[i][j][k][0] = 0;
                    }
                } else if (a[i][j] == 'C') {
                    if (x1 == -1) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        x2 = j;
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            int dir = p.dir;
            int s = p.s;
            if (s == 3) {
                ans = d[x][y][dir][s];
                break;
            }
            for (int k=0; k<4; k++) {
                if (dir == k) continue;
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] != '#') {
                        int ns = s;
                        if (a[nx][ny] == 'C') {
                            if (nx == x1 && ny == y1) {
                                ns |= 1;
                            } else {
                                ns |= 2;
                            }
                        }
                        if (d[nx][ny][k][ns] == -1) {
                            d[nx][ny][k][ns] = d[x][y][dir][s] + 1;
                            q.add(new Pair(nx,ny,k,ns));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
