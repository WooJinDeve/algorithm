import java.util.*;
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
        int[][][][] d = new int[n][n][n*n][3];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n*n; k++) {
                    for (int l=0; l<3; l++) {
                        d[i][j][k][l] = -1;
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
                        d[i][j][0][k] = 0;
                        q.add(i); q.add(j); q.add(0); q.add(k);
                    }
                }
            }
        }
        int ans = -1;
        while (!q.isEmpty()) {
            int x = q.remove();
            int y = q.remove();
            int num = q.remove();
            int piece = q.remove();
            if (num == n*n-1) {
                if (ans == -1 || ans > d[x][y][num][piece]) {
                    ans = d[x][y][num][piece];
                }
            }
            for (int i=0; i<3; i++) {
                if (piece == i) continue;
                if (d[x][y][num][i] == -1) {
                    d[x][y][num][i] = d[x][y][num][piece] + 1;
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
                        if (d[nx][ny][next_num][piece] == -1) {
                            d[nx][ny][next_num][piece] = d[x][y][num][piece] + 1;
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
                            if (d[nx][ny][next_num][piece] == -1) {
                                d[nx][ny][next_num][piece] = d[x][y][num][piece] + 1;
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
                            if (d[nx][ny][next_num][piece] == -1) {
                                d[nx][ny][next_num][piece] = d[x][y][num][piece] + 1;
                                q.add(nx); q.add(ny); q.add(next_num); q.add(piece);
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}