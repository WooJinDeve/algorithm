import java.util.Scanner;

public class Main {

    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[M];

        backtracking(1, 0);

        System.out.println(sb);
    }

    public static void backtracking(int at, int depth) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {

            arr[depth] = i;
            backtracking(i, depth + 1);

        }
    }
}