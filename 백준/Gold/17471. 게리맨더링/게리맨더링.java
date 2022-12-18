import java.util.*;
public class Main {
    static int n;
    static int[] people = new int[10];
    static int[] group = new int[10];
    static boolean[] check = new boolean[10];
    static boolean[][] a = new boolean[10][10];
    static void dfs(int x) {
        check[x] = true;
        for (int i=0; i<n; i++) {
            if (check[i]) continue;
            if (group[x] != group[i]) continue;
            if (a[x][i]) {
                dfs(i);
            }
        }
    }
    static int go(int index) {
        if (index == n) {
            int people1 = 0;
            int people2 = 0;
            int start1 = -1;
            int start2 = -1;
            for (int i=0; i<n; i++) {
                check[i] = false;
                if (group[i] == 1) {
                    people1 += people[i];
                    start1 = i;
                } else {
                    people2 += people[i];
                    start2 = i;
                }
            }
            if (start1 == -1 || start2 == -1) return -1;
            dfs(start1);
            dfs(start2);
            for (int i=0; i<n; i++) {
                if (check[i] == false) {
                    return -1;
                }
            }
            int diff = people1 - people2;
            if (diff < 0) diff = -diff;
            return diff;
        }
        int ans = -1;
        group[index] = 1;
        int t1 = go(index+1);
        group[index] = 2;
        int t2 = go(index+1);
        if (t1 != -1 && (ans == -1 || ans > t1)) {
            ans = t1;
        }
        if (t2 != -1 && (ans == -1 || ans > t2)) {
            ans = t2;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            people[i] = sc.nextInt();
        }
        for (int i=0; i<n; i++) {
            int cnt = sc.nextInt();
            while (cnt-- > 0) {
                int x = sc.nextInt();
                x -= 1;
                a[i][x] = true;
            }
        }
        int ans = go(0);
        System.out.println(ans);
    }
}