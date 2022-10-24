import java.util.*;
public class Main {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int n = 5;
    static int[][] a = new int[5][5];
    static HashSet<Integer> ans = new HashSet<>();
    static void go(int x, int y, int num, int len) {
        if (len == 6) {
            ans.add(num);
            return;
        }
        for (int k=0; k<4; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                go(nx,ny,num*10+a[nx][ny],len+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                go(i,j,a[i][j],1);
            }
        }
        System.out.println(ans.size());
    }
}