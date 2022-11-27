import java.util.*;
import java.io.*;
public class Main {
    static final int[] dx = {1,0,-1,0};
    static final int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][n];
        int x = 0;
        int y = 0;
        a[0][0] = n*n;
        int k = 0;
        for (int i=n*n-1; i>=1; i--) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && a[nx][ny] == 0) {

            } else {
                k = (k+1)%4;
                nx = x+dx[k];
                ny = y+dy[k];
            }
            a[nx][ny] = i;
            x = nx;
            y = ny;
        }
        x = 0;
        y = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                bw.write(a[i][j] + " " );
                if (a[i][j] == m) {
                    x = i+1;
                    y = j+1;
                }
            }
            bw.write("\n");
        }
        bw.flush();
        System.out.println(x + " " + y);
    }
}