import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] answer = new int[n + 1];
   
        for(int i = 0; i < m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            for(int idx = start; idx <= end; idx++)
                answer[idx] = value;
        }
        
        for(int i = 1; i <= n; i++)
            System.out.print(answer[i] + " ");
    }
}