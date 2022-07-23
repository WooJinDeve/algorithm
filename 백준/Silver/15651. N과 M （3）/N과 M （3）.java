import java.util.*;

public class Main{
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[M];

        backtracking(N,M,0);

        System.out.println(sb);
    }

    public static void backtracking(int N, int M, int count){
        if (count == M) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
                arr[count] = i;
                backtracking(N, M, count + 1);
        }
    }
}