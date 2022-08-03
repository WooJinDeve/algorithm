import java.util.*;
public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int l = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] dice = new int[7];
        while (l-- > 0) {
            int k = sc.nextInt() - 1;
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                // 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 함, 출력도 하면 안됨
                continue;
            }
            if (k == 0) { // right
                int temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
            } else if (k == 1) { // left
                int temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
            } else if (k == 2) { // up
                int temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
            } else { // down
                int temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
            }
            x = nx;
            y = ny;
            if (a[x][y] == 0) {
                // 주사위를 굴렸을 때, 이동한 칸에 써 있는 수가 0이면, 주사위의 바닥면에 써 있는 수가 칸에 복사됨
                a[x][y] = dice[6];
            } else {
                // 0이 아닌 경우에는 칸에 써 있는 수가 주사위의 바닥면으로 복사되며,
                dice[6] = a[x][y];
                // 칸에 써 있는 수는 0이 복사됨
                a[x][y] = 0;
            }
            System.out.println(dice[1]);
        }
    }
}