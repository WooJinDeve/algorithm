import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int T = sc.nextInt();
        int[] arr = new int[T];
        for(int i = 0; i<T; i++)
            arr[i] = sc.nextInt();

       for (int i = 0; i<T; i++){

           while (!stack.empty() && arr[stack.peek()] < arr[i]){
               arr[stack.pop()] = arr[i];
           }

           stack.push(i);
       }

        while(!stack.empty()){
            arr[stack.pop()] = -1;
        }

        for(int i : arr)
            sb.append(i).append(' ');

        System.out.println(sb);
    }
}