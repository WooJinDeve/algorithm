import java.util.*;

class Main {
    static int simulate(int[][] board, int col, int type) {
        // type = 1 1x1, 2 = garo (col, col+1), 3 = sero
        int ans = 0;
        int max_row = -1;
        for (int i=0; i<board.length; i++) {
            if (board[i][col] == 0) {
                max_row = i;
            } else {
                break;
            }
        }
        if (type == 2) {
            int max_row_2 = -1;
            for (int i=0; i<board.length; i++) {
                if (board[i][col+1] == 0) {
                    max_row_2 = i;
                } else {
                    break;
                }
            }
            max_row = Math.min(max_row, max_row_2);
        }
        board[max_row][col] = 1;
        if (type == 2) board[max_row][col+1] = 1;
        if (type == 3) board[max_row-1][col] = 1;
        int deleted_row = -1;
        for (int i=0; i<board.length; i++) {
            boolean all = true;
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == 0) {
                    all = false;
                }
            }
            if (all) {
                if (deleted_row < i) {
                    deleted_row = i;
                }
                ans += 1;
                for (int j=0; j<board[i].length; j++) {
                    board[i][j] = 0;
                }
            }
        }
        if (ans > 0) {
            for (int i=deleted_row; i>=0; i--) {
                for (int j=0; j<board[i].length; j++) {
                    board[i][j] = 0;
                    if (i-ans >= 0) {
                        board[i][j] = board[i-ans][j];
                    }
                }
            }
        }
        int cnt = 0;
        for (int i=0; i<2; i++) {
            boolean exists = false;
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] != 0) {
                    exists = true;
                }
            }
            if (exists) cnt += 1;
        }
        if (cnt > 0) {
            int bn = board.length;
            for (int i=bn-1; i>=0; i--) {
                for (int j=0; j<board[i].length; j++) {
                    board[i][j] = 0;
                    if (i-cnt >= 0) {
                        board[i][j] = board[i-cnt][j];
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int[][] green = new int[6][4];
        int[][] blue = new int[6][4];
        while (n-- > 0) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (t == 1) {
                ans += simulate(green, y, 1);
            } else if (t == 2) {
                ans += simulate(green, y, 2);
            } else if (t == 3) {
                ans += simulate(green, y, 3);
            }
            if (t == 1) {
                ans += simulate(blue, x, 1);
            } else if (t == 2) {
                ans += simulate(blue, x, 3);
            } else if (t == 3) {
                ans += simulate(blue, x, 2);
            }
        }
        System.out.println(ans);
        int cnt = 0;
        for (int i=0; i<green.length; i++) {
            for (int j=0; j<green[i].length; j++) {
                if (green[i][j] > 0) cnt += 1;
            }
        }
        for (int i=0; i<blue.length; i++) {
            for (int j=0; j<blue[i].length; j++) {
                if (blue[i][j] > 0) cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}