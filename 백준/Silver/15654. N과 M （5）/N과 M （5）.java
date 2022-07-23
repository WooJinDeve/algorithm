import java.util.*;

public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visit;
    public static int[] result;
    public static int[] arr;
    public static int N;
    public static int M;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        result = new int[M];
        visit = new boolean[N];
        for(int i = 0; i<N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        backtracking(0);
        System.out.println(sb);
    }
    public static void backtracking(int count){
        if(count == M){
            for(int i : result)
                sb.append(i).append(" ");            
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                result[count] = arr[i];
                backtracking(count+1);
                visit[i] = false;
            }
        }
    }
}