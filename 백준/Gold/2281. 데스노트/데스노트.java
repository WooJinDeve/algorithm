import java.util.*;
public class Main {
    static int[] a = new int[1001];
    static int[][] d = new int[1000][1002];
    static int n, m;
    static int go(int index, int cnt) {
        if (index == n) return 0;
        int ans = d[index][cnt];
        if (ans != -1) return ans;
        int space = (m-(cnt-1));
        int cost = space*space;
        ans = go(index+1, a[index]+1)+cost;
        if (cnt + a[index] <= m) {
            int cur = go(index+1, cnt + a[index] + 1);
            if (ans > cur) ans = cur;
        }
        d[index][cnt] = ans;
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i=0; i<1000; i++) {
            Arrays.fill(d[i], -1);
        }
        System.out.println(go(1, a[0]+1));
    }
}