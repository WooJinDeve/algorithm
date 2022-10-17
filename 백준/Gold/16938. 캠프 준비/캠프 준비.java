import java.util.*;
public class Main {
    static int n, l, r, x;
    static int[] a = new int[15];
    static int go(int index, int cnt, int sum, int easy, int hard) {
        if (index == n) {
            if (cnt >= 2 && l <= sum && sum <= r && hard-easy >= x) return 1;
            else return 0;
        }
        int cnt1 = go(index+1, cnt+1, sum+a[index], Math.min(easy,a[index]), Math.max(hard,a[index]));
        int cnt2 = go(index+1, cnt, sum, easy, hard);
        return cnt1+cnt2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        x = sc.nextInt();
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(go(0, 0, 0, 1000000, 0));
    }
}