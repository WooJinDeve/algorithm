import java.util.*;

public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visite;
    public static int[] result;
    public static int[] arr;
    public static int N;
    public static int M;
    public static HashSet<String> hashSet = new HashSet<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visite = new boolean[N];
        arr = new int[N];
        result = new int[M];
        for(int i = 0; i<N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        backtracking(0);
        System.out.println(sb);
    }
    public static void backtracking(int count){
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

        for(int i = 0; i < arr.length; i++){
            if(!visite[i]){
                visite[i] =true;
                result[count] = arr[i];
                backtracking(count+1);
                visite[i] = false;
            }
        }
    }
}