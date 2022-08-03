import java.util.*;
public class Main {
    final static int[] dx = {0,0,0,0,1,-1};
    final static int[] dy = {0,0,1,-1,0,0};
    final static int[] dz = {1,-1,0,0,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[102][102];
        boolean[][][] d = new boolean[102][102][102];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                a[i][j] = sc.nextInt();
                for (int k=1; k<=a[i][j]; k++) {
                    d[i][j][k] = true;
                }
            }
        }
        int ans = 0;
        for (int x=1; x<=n; x++) {
            for (int y=1; y<=m; y++) {
                for (int z=1; z<=a[x][y]; z++) {
                    for (int k=0; k<6; k++) {
                        int nx = x+dx[k];
                        int ny = y+dy[k];
                        int nz = z+dz[k];
                        if (d[nx][ny][nz] == false) ans += 1;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
