import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static char[] alpha;
    private static char[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();
        alpha = new char[C];
        result = new char[L];

        for (int i = 0; i < C; i++)
            alpha[i] = sc.next().charAt(0);

        Arrays.sort(alpha);

        bfs(0, 0, C, L);
    }

    private static void bfs(int start, int depth, int N, int M) {
        if (depth == M) {
            if (check(result))
                System.out.println(result);
            return;
        }

        for (int i = start; i < N; i++) {
            result[depth] = alpha[i];
            bfs(i + 1, depth + 1, N, M);
        }
    }

    private static boolean check(char[] check) {
        int mo = 0;
        int ja = 0;
        for (char x : check) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo += 1;
            } else {
                ja += 1;
            }
        }
        return ja >= 2 && mo >= 1;
    }
}