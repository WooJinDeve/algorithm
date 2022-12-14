import java.util.*;
public class Main {
    static int n;
    static int[] s = new int[10];
    static int[] w = new int[10];
    static int go(int index) {
        if (index == n) {
            int cnt = 0;
            for (int i=0; i<n; i++) {
                if (s[i] <= 0) {
                    cnt += 1;
                }
            }
            return cnt;
        }
        if (s[index] <= 0) {
            return go(index+1);
        }
        int ans = 0;
        boolean ok = false;
        for (int j=0; j<n; j++) {
            int i = index;
            if (i == j) continue;
            if (s[j] > 0) {
                ok = true;
                s[i] -= w[j];
                s[j] -= w[i];
                int temp = go(index+1);
                if (ans < temp) ans = temp;
                s[i] += w[j];
                s[j] += w[i];
            }
        }
        if (!ok) {
            return go(index+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            s[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        System.out.println(go(0));
    }
}