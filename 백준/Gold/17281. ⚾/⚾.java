import java.util.*;
public class Main {
    static int n;
    static int[][] a = new int[100][9];
    static int[] player = new int[9];
    static boolean[] check = new boolean[9];
    static int simulate() {
        int now = 0;
        int score = 0;
        for (int inning=0; inning<n; inning++) {
            int b1 = 0;
            int b2 = 0;
            int b3 = 0;
            int out = 0;
            while (out < 3) {
                int res = a[inning][player[now]];
                if (res == 0) {
                    out += 1;
                } else if (res == 1) {
                    score += b3;
                    b3 = b2; b2 = b1; b1 = 1;
                } else if (res == 2) {
                    score += b3 + b2;
                    b3 = b1; b2 = 1; b1 = 0;
                } else if (res == 3) {
                    score += b3 + b2 + b1;
                    b3 = 1; b2 = 0; b1 = 0;
                } else if (res == 4) {
                    score += b3 + b2 + b1 + 1;
                    b3 = 0; b2 = 0; b1 = 0;
                }
                now += 1;
                if (now == 9) now = 0;
            }
        }
        return score;
    }
    static int go(int index) {
        if (index == 9) {
            return simulate();
        }
        if (index == 3) {
            player[index] = 0;
            return go(index+1);
        }
        int ans = 0;
        for (int i=1; i<9; i++) {
            if (check[i]) continue;
            check[i] = true;
            player[index] = i;
            int temp = go(index+1);
            if (ans < temp) ans = temp;
            check[i] = false;
            player[index] = 0;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<9; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(go(0));
    }
}