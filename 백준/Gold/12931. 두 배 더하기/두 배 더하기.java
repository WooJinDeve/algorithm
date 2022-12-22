import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int len = 0;
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int cnt = 0;
            while (x > 0) {
                cnt += 1;
                ans += x%2;
                x /= 2;
            }
            len = Math.max(len, cnt);
        }
        ans += len - 1;
        if (ans < 0) ans = 0;
        System.out.println(ans);
    }
}