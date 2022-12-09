import java.util.*;
class Pair implements Comparable<Pair> {
    int dist;
    int change;
    Pair(int dist, int change) {
        this.dist = dist;
        this.change = change;
    }
    @Override
    public int hashCode() {
        return Objects.hash(dist, change);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair that = (Pair)obj;
            if (this.dist == that.dist && this.change == that.change) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public int compareTo(Pair that) {
        if (this.dist < that.dist) {
            return -1;
        } else if (this.dist == that.dist) {
            if (this.change < that.change) return -1;
            else if (this.change == that.change) return 0;
            else return 1;
        } else {
            return 1;
        }
    }
}

public class Main {
    final static int[] dx1 = {-2,-1,1,2,2,1,-1,-2};
    final static int[] dy1 = {1,2,2,1,-1,-2,-2,-1};
    final static int[] dx2 = {0,0,1,-1};
    final static int[] dy2 = {1,-1,0,0};
    final static int[] dx3 = {1,1,-1,-1};
    final static int[] dy3 = {1,-1,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[][][][] d = new Pair[n][n][n*n][3];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n*n; k++) {
                    for (int l=0; l<3; l++) {
                        d[i][j][k][l] = new Pair(-1, -1);
                    }
                }
            }
        }
        int[][] a = new int[n][n];
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt()-1;
                if (a[i][j] == 0) {
                    for (int k=0; k<3; k++) {
                        d[i][j][0][k] = new Pair(0, 0);
                        q.add(i); q.add(j); q.add(0); q.add(k);
                    }
                }
            }
        }
        Pair ans = new Pair(-1, -1);
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int num = q.remove();
            int piece = q.remove();
            Pair p = d[x][y][num][piece];
            if (num == n*n-1) {
                if (ans.dist == -1 || ans.compareTo(p) > 0) {
                    ans = p;
                }
            }
            for (int i=0; i<3; i++) {
                if (piece == i) continue;
                Pair np = new Pair(p.dist+1, p.change+1);
                if (d[x][y][num][i].dist == -1 || d[x][y][num][i].compareTo(np) > 0) {
                    d[x][y][num][i] = np;
                    q.add(x); q.add(y); q.add(num); q.add(i);
                }
            }
            if (piece == 0) { // knight
                for (int k=0; k<8; k++) {
                    int nx = x+dx1[k];
                    int ny = y+dy1[k];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        int next_num = num;
                        if (a[nx][ny] == num+1) {
                            next_num = num+1;
                        }
                        Pair np = new Pair(p.dist+1, p.change);
                        if (d[nx][ny][next_num][piece].dist == -1 || d[nx][ny][next_num][piece].compareTo(np) > 0) {
                            d[nx][ny][next_num][piece] = np;
                            q.add(nx); q.add(ny); q.add(next_num); q.add(piece);
                        }
                    }
                }
            } else if (piece == 1) { // rook
                for (int k=0; k<4; k++) {
                    for (int l=1;; l++) {
                        int nx = x+dx2[k]*l;
                        int ny = y+dy2[k]*l;
                        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                            int next_num = num;
                            if (a[nx][ny] == num+1) {
                                next_num = num+1;
                            }
                            Pair np = new Pair(p.dist+1, p.change);
                            if (d[nx][ny][next_num][piece].dist == -1 || d[nx][ny][next_num][piece].compareTo(np) > 0) {
                                d[nx][ny][next_num][piece] = np;
                                q.add(nx); q.add(ny); q.add(next_num); q.add(piece);
                            }
                        } else {
                            break;
                        }
                    }
                }
            } else { // bishop
                for (int k=0; k<4; k++) {
                    for (int l=1;; l++) {
                        int nx = x+dx3[k]*l;
                        int ny = y+dy3[k]*l;
                        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                            int next_num = num;
                            if (a[nx][ny] == num+1) {
                                next_num = num+1;
                            }
                            Pair np = new Pair(p.dist+1, p.change);
                            if (d[nx][ny][next_num][piece].dist == -1 || d[nx][ny][next_num][piece].compareTo(np) > 0) {
                                d[nx][ny][next_num][piece] = np;
                                q.add(nx); q.add(ny); q.add(next_num); q.add(piece);
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans.dist + " " + ans.change);
    }
}