import java.util.*;
public class Main {
    static int[] a = new int[1000];
    static int[][] d = new int[1000][1000];
    static int go(int i, int j) {
        if (i >= j) return 0;
        int ans = d[i][j];
        if (ans != -1) return ans;
        ans = go(i+1, j);
        for (int k=i+1; k<=j; k++) {
            int cur = 0;
            if (a[i] == a[k]) {
                cur = go(i+1, k-1) + go(k+1, j) + 1;
            }
            if (ans < cur) {
                ans = cur;
            }
        }
        d[i][j] = ans;
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i=0; i<n; i++) {
            Arrays.fill(d[i],-1);
        }
        System.out.println(go(0, n-1));
    }
}