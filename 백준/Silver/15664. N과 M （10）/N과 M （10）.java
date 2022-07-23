import java.util.*;

public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static int[] result;
    public static int[] arr;
    public static int N;
    public static int M;
    public static HashSet<String> hashSet = new HashSet<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        result = new int[M];
        for(int i = 0; i<N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        backtracking(0,0);
        System.out.println(sb);
    }
    public static void backtracking(int at, int count){
        if(count == M){
            StringBuilder temp = new StringBuilder();
            for(int i : result)
                temp.append(i).append(" ");
            temp.append('\n');
            if(!hashSet.contains(temp.toString())){
                sb.append(temp);
                hashSet.add(temp.toString());
            }
            return;
        }

        for(int i = at; i < arr.length; i++){
            result[count] = arr[i];
            backtracking(i+1,count+1);
        }
    }
}