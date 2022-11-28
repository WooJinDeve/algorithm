import java.util.*;
import java.io.*;
public class Main {
    static final int[] dx = {0,1,0,-1};
    static final int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        int x = 0;
        int y = 0;
        a[0][0] = n*m;
        int k = 0;
        int ans = 0;
        for (int i=n*m-1; i>=1; i--) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && a[nx][ny] == 0) {

            } else {
                k = (k+1)%4;
                nx = x+dx[k];
                ny = y+dy[k];
                ans += 1;
            }
            a[nx][ny] = i;
            x = nx;
            y = ny;
        }
        System.out.println(ans);
    }
}