import java.util.*;

class Main {
    static final int n = 4;
    static final int[] dx = {-1,-1,0,1,1,1,0,-1};
    static final int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int[][] copy_2d_array(int[][] original) {
        int[][] result = new int[original.length][];
        for (int i=0; i<original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
    static int go(int[][] num, int[][] dir, int x, int y, int d) {
        for (int who=1; who<=n*n; who++) {
            boolean f = false;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (num[i][j] == who) {
                        for (int k=0; k<8; k++) {
                            int nx = i+dx[dir[i][j]];
                            int ny = j+dy[dir[i][j]];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n && num[nx][ny] >= 0 && !(nx == x && ny == y)) {
                                int temp;
                                // swap(num[i][j], num[nx][ny]);
                                temp = num[i][j];
                                num[i][j] = num[nx][ny];
                                num[nx][ny] = temp;
                                // swap(dir[i][j], dir[nx][ny]);
                                temp = dir[i][j];
                                dir[i][j] = dir[nx][ny];
                                dir[nx][ny] = temp;
                                f = true;
                                break;
                            } else {
                                dir[i][j] += 1;
                                dir[i][j] %= 8;
                            }
                        }
                    }
                    if (f) break;
                }
                if (f) break;
            }
        }
        int ans = 0;
        int sx = x+dx[d];
        int sy = y+dy[d];
        while (0 <= sx && sx < n && 0 <= sy && sy < n) {
            if (num[sx][sy] != 0) {
                int temp = num[sx][sy];
                num[sx][sy] = 0;
                int cur = temp + go(copy_2d_array(num), copy_2d_array(dir), sx, sy, dir[sx][sy]);
                if (ans < cur) ans = cur;
                num[sx][sy] = temp;
            }
            sx += dx[d];
            sy += dy[d];
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] num = new int[n][n];
        int[][] dir = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                num[i][j] = sc.nextInt();
                dir[i][j] = sc.nextInt();
                dir[i][j] -= 1;
            }
        }

        int ans = num[0][0];
        num[0][0] = 0;
        ans += go(num, dir, 0, 0, dir[0][0]);
        System.out.println(ans);
    }
}
