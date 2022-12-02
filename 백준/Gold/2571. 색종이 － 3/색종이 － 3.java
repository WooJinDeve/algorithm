import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[100][100];
        int[][] s = new int[100][100];
        int n = sc.nextInt();
        for (int k=0; k<n; k++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int i=x; i<x+10; i++) {
                for (int j=y; j<y+10; j++) {
                    a[i][j] = 1;
                }
            }
        }
        for (int i=1; i<100; i++) {
            for (int j=1; j<100; j++) {
                if (a[i][j] == 1) {
                    s[i][j] = s[i][j-1] + a[i][j];
                }
            }
        }
        int ans = 0;
        for (int i=1; i<100; i++) {
            for (int j=1; j<100; j++) {
                if (a[i][j] == 0) continue;
                int height = 0;
                int width = s[i][j];
                for (int k=i; k>=1; k--) {
                    if (s[k][j] == 0) break;
                    height += 1;
                    width = Math.min(width, s[k][j]);
                    if (ans < width*height) {
                        ans = width*height;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}