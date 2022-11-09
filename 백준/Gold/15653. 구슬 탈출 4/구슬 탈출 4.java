import java.util.*;
class Pair {
    boolean first, second;
    Pair(boolean first, boolean second) {
        this.first = first;
        this.second = second;
    }
}
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Points {
    int rx, ry, bx, by;
    Points(int rx, int ry, int bx, int by) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
    }
}
public class Main {
    static final int[] dx = {0,0,1,-1};
    static final int[] dy = {1,-1,0,0};
    static int hx = 0;
    static int hy = 0;
    static Pair simulate(char[][] a, int k, Point p) {
        int x = p.x;
        int y = p.y;
        if (a[x][y] == '.') return new Pair(false, false);
        int n = a.length;
        int m = a[0].length;
        boolean moved = false;
        while (true) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                p.x = x; p.y = y;
                return new Pair(moved, false);
            }
            char ch = a[nx][ny];
            if (ch == '#') {
                p.x = x; p.y = y;
                return new Pair(moved, false);
            } else if (ch == 'R' || ch == 'B') {
                p.x = x; p.y = y;
                return new Pair(moved, false);
            } else if (ch == '.') {
                char temp = a[nx][ny];
                a[nx][ny] = a[x][y];
                a[x][y] = temp;
                x = nx;
                y = ny;
                moved = true;
            } else if (ch == 'O') {
                a[x][y] = '.';
                moved = true;
                p.x = x; p.y = y;
                return new Pair(moved, true);
            }
        }
    }
    static Pair next(char[][] a, Points p, int dir) {
        int n = a.length;
        int m = a[0].length;
        char[][] b = new char[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                b[i][j] = a[i][j];
            }
        }
        int rx = p.rx, ry = p.ry, bx = p.bx, by = p.by;
        b[rx][ry] = 'R';
        b[bx][by] = 'B';
        Point red = new Point(rx, ry);
        Point blue = new Point(bx, by);
        boolean hole1 = false, hole2 = false;
        while (true) {
            Pair p1 = simulate(b, dir, red);
            Pair p2 = simulate(b, dir, blue);
            if (p1.first == false && p2.first == false) {
                break;
            }
            if (p1.second) hole1 = true;
            if (p2.second) hole2 = true;
        }
        p.rx = red.x; p.ry = red.y; p.bx = blue.x; p.by = blue.y;
        return new Pair(hole1, hole2);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][m];
        for (int i=0; i<n; i++) {
            String s = sc.next();
            a[i] = s.toCharArray();
        }
        int ans = -1;
        Queue<Points> q = new LinkedList<>();
        int rx=0,ry=0,bx=0,by=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 'O') {
                    hx = i; hy = j;
                } else if (a[i][j] == 'R') {
                    rx = i; ry = j;
                    a[i][j] = '.';
                } else if (a[i][j] == 'B') {
                    bx = i; by = j;
                    a[i][j] = '.';
                }
            }
        }
        int[][][][] d = new int[n][m][n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=0; k<n; k++) {
                    Arrays.fill(d[i][j][k],-1);
                }
            }
        }
        q.add(new Points(rx, ry, bx, by));
        d[rx][ry][bx][by] = 0;
        boolean found = false;
        while (!q.isEmpty()) {
            Points temp = q.remove();
            rx = temp.rx;
            ry = temp.ry;
            bx = temp.bx;
            by = temp.by;
            for (int k=0; k<4; k++) {
                boolean hole1 = false, hole2 = false;
                int nrx = rx, nry = ry, nbx = bx, nby = by;
                temp = new Points(nrx,nry,nbx,nby);
                Pair p = next(a,temp,k);
                nrx = temp.rx;
                nry = temp.ry;
                nbx = temp.bx;
                nby = temp.by;
                hole1 = p.first;
                hole2 = p.second;
                if (hole2) continue;
                if (hole1) {
                    found = true;
                    ans = d[rx][ry][bx][by] + 1;
                    break;
                }
                if (d[nrx][nry][nbx][nby] != -1) continue;
                q.add(new Points(nrx,nry,nbx,nby));
                d[nrx][nry][nbx][nby] = d[rx][ry][bx][by] + 1;
            }
            if (found) {
                break;
            }
        }
        System.out.println(ans);
    }
}