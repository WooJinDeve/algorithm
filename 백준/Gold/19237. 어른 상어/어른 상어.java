import java.util.*;
class Shark implements Comparable<Shark>{
    int number, row, col;
    Shark(int number, int row, int col) {
        this.number = number;
        this.row = row;
        this.col = col;
    }
    public int compareTo(Shark that) {
        if (this.number < that.number) {
            return -1;
        } else if (this.number == that.number) {
            if (this.row < that.row) {
                return -1;
            } else if (this.row == that.row) {
                if (this.col < that.col) {
                    return -1;
                } else if (this.col == that.col) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
class Main {
    static final int limit = 1000;
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    static int[][] shark;
    static int[][] shark_next;
    static int[][] smell;
    static int[][] smell_who;
    static int[] dir;
    static int[][][] priority;
    static int n, m, smell_time;
    static boolean check_1() {
        int cnt = 0;
        int one = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (shark[i][j] > 0) {
                    cnt += 1;
                }
                if (shark[i][j] == 1) {
                    one += 1;
                }
            }
        }
        return cnt == 1;
    }
    static void move_shark() {
        ArrayList<Shark> v = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                shark_next[i][j] = 0;
                if (shark[i][j] > 0) {
                    v.add(new Shark(shark[i][j], i, j));
                }
            }
        }
        Collections.sort(v);
        for (Shark t : v) {
            int no = t.number;
            int x = t.row;
            int y = t.col;
            int shark_dir = dir[no];
            boolean ok = false;
            for (int k=0; k<4; k++) {
                int nx = x+dx[priority[no][shark_dir][k]];
                int ny = y+dy[priority[no][shark_dir][k]];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (smell[nx][ny] == 0) {
                        if (shark_next[nx][ny] == 0) {
                            shark_next[nx][ny] = no;
                            dir[no] = priority[no][shark_dir][k];
                        } else {
                            if (shark_next[nx][ny] > no) {
                                shark_next[nx][ny] = no;
                                dir[no] = priority[no][shark_dir][k];
                            }
                        }
                        ok = true;
                        break;
                    }
                }
                if (ok) break;
            }
            if (!ok) {
                for (int k=0; k<4; k++) {
                    int nx = x+dx[priority[no][shark_dir][k]];
                    int ny = y+dy[priority[no][shark_dir][k]];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (smell[nx][ny] > 0 && smell_who[nx][ny] == no) {
                            shark_next[nx][ny] = no;
                            dir[no] = priority[no][shark_dir][k];
                            ok = true;
                            break;
                        }
                    }
                    if (ok) break;
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                shark[i][j] = shark_next[i][j];
                if (smell[i][j] > 0) {
                    smell[i][j] -= 1;
                }
                if (smell[i][j] == 0) {
                    smell_who[i][j] = 0;
                }
                if (shark[i][j] > 0) {
                    smell[i][j] = smell_time;
                    smell_who[i][j] = shark[i][j];
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        smell_time = sc.nextInt();
        shark = new int[n][n];
        shark_next = new int[n][n];
        smell = new int[n][n];
        smell_who = new int[n][n];
        dir = new int[m+1];
        priority = new int[m+1][4][4];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                shark[i][j] = sc.nextInt();
                if (shark[i][j] > 0) {
                    smell[i][j] = smell_time;
                    smell_who[i][j] = shark[i][j];
                }
            }
        }
        for (int i=1; i<=m; i++) {
            dir[i] = sc.nextInt() - 1;
        }
        for (int i=1; i<=m; i++) {
            for (int j=0; j<4; j++) {
                for (int k=0; k<4; k++) {
                    priority[i][j][k] = sc.nextInt()-1;
                }
            }
        }
        int ans = -1;
        for (int t=1; t<=limit; t++) {
            move_shark();
            if (check_1()) {
                ans = t;
                break;
            }
        }
        System.out.println(ans);
    }
}
