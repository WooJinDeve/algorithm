import java.util.*;
class Piece {
    int no;
    int dir;
    Piece(int no, int dir) {
        this.no = no;
        this.dir = dir;
    }
}
class Tuple {
    int row, col, index;
    Tuple(int row, int col, int index) {
        this.row = row;
        this.col = col;
        this.index = index;
    }
}
public class Main {
    static final int[] dx = {0,0,-1,1};
    static final int[] dy = {1,-1,0,0};
    static int opposite(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        return 2;
    }
    static void go(ArrayList<Piece>[][] a, Tuple[] where, int x, int y, int nx, int ny, int start) {
        for (int i=start; i<a[x][y].size(); i++) {
            Piece p = a[x][y].get(i);
            a[nx][ny].add(p);
            where[p.no] = new Tuple(nx, ny, a[nx][ny].size()-1);
        }
        a[x][y] = new ArrayList<>(a[x][y].subList(0, start));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][n];
        ArrayList<Piece>[][] a = new ArrayList[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = new ArrayList<>();
                board[i][j] = sc.nextInt();
            }
        }
        Tuple[] where = new Tuple[m];
        for (int i=0; i<m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int dir = sc.nextInt()-1;
            a[x][y].add(new Piece(i, dir));
            where[i] = new Tuple(x, y, a[x][y].size()-1);
        }
        for (int turn=1; turn<=1000; turn++) {
            for (int k=0; k<m; k++) {
                int x = where[k].row;
                int y = where[k].col;
                int index = where[k].index;
                int dir = a[x][y].get(index).dir;
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) { // in
                    if (board[nx][ny] == 2) {
                        a[x][y].get(index).dir = opposite(dir);
                    }
                } else {
                    a[x][y].get(index).dir = opposite(dir);
                }
                dir = a[x][y].get(index).dir;
                nx = x+dx[dir];
                ny = y+dy[dir];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) { // in
                    if (board[nx][ny] == 0) {
                        go(a, where, x, y, nx, ny, index);
                    } else if (board[nx][ny] == 1) {
                        List<Piece> temp = a[x][y].subList(index, a[x][y].size());
                        Collections.reverse(temp);
                        go(a, where, x, y, nx, ny, index);
                    }
                    if (a[nx][ny].size() >= 4) {
                        System.out.println(turn);
                        System.exit(0);
                    }
                } else { // out
                }
            }
        }
        System.out.println(-1);
    }
}