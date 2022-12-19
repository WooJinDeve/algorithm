import java.util.*;
public class Main {
    static int n = 10;
    static int[][] a = new int[n][n];
    static int[] avail = {0,5,5,5,5,5};
    static int go(int z) {
        if (z == n*n) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (a[i][j] == 1) return -1;
                }
            }
            return 0;
        }
        int x = z/n;
        int y = z%n;
        if (a[x][y] == 0) {
            return go(z+1);
        }
        int ans = -1;
        for (int k=5; k>=1; k--) {
            if (avail[k] > 0) {
                if (x+k-1 < n && y+k-1 < n) {
                    boolean ok = true;
                    for (int i=x; i<x+k; i++) {
                        for (int j=y; j<y+k; j++) {
                            if (a[i][j] == 0) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok == false) {
                            break;
                        }
                    }
                    if (ok) {
                        for (int i=x; i<x+k; i++) {
                            for (int j=y; j<y+k; j++) {
                                a[i][j] = 0;
                            }
                        }
                        avail[k] -= 1;
                        int temp = go(z+1);
                        avail[k] += 1;
                        if (temp != -1) {
                            if (ans == -1 || ans > temp+1) {
                                ans = temp+1;
                            }
                        }
                        for (int i=x; i<x+k; i++) {
                            for (int j=y; j<y+k; j++) {
                                a[i][j] = 1;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(go(0));
    }
}