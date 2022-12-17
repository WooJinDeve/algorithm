import java.util.*;
public class Main {
    final static int n = 3;
    static int[][] magic = {
        {8, 1, 6, 3, 5, 7, 4, 9, 2},
        {6, 1, 8, 7, 5, 3, 2, 9, 4},
        {4, 3, 8, 9, 5, 1, 2, 7, 6},
        {2, 7, 6, 9, 5, 1, 4, 3, 8},
        {2, 9, 4, 7, 5, 3, 6, 1, 8},
        {4, 9, 2, 3, 5, 7, 8, 1, 6},
        {6, 7, 2, 1, 5, 9, 8, 3, 4},
        {8, 3, 4, 1, 5, 9, 6, 7, 2}
    };
    static int diff(int[] a, int[] d) {
        int ans = 0;
        for (int i=0; i<n*n; i++) {
            int temp = a[i] - d[i];
            if (temp < 0) temp = -temp;
            ans += temp;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[n*n];
        for (int i=0; i<n*n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = -1;
        for (int[] d : magic) {
            int cost = diff(a, d);
            if (ans == -1 || ans > cost) {
                ans = cost;
            }
        }
        System.out.println(ans);
    }
}