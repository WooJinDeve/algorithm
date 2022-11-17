import java.util.*;

public class Main {
    static char get_prev(char x) {
        if (x == 'B') {
            return 'J';
        } else if (x == 'O') {
            return 'B';
        } else if (x == 'J') {
            return 'O';
        } else {
            return ' ';
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] d = new int[n];
        for (int i=0; i<n; i++) d[i] = -1;
        d[0] = 0;
        for (int i=1; i<n; i++) {
            char now = s.charAt(i);
            char prev = get_prev(now);
            for (int j=0; j<i; j++) {
                if (d[j] == -1) continue;
                if (s.charAt(j) != prev) continue;
                int cost = d[j] + (i-j)*(i-j);
                if (d[i] == -1 || d[i] > cost) {
                    d[i] = cost;
                }
            }
        }
        System.out.println(d[n-1]);
    }
}