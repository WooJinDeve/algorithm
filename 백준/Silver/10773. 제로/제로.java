import java.util.*;

public class Main {
    public static void main(String[] args){
    	 Scanner sc = new Scanner(System.in);
         Stack<Integer> stk = new Stack<>();
         int result = 0;
         
         for(int i = sc.nextInt(); i>0; i--){
             int n = sc.nextInt();
             if(n != 0){
                 stk.push(n);
                 result += n;
             }else{
                 result -= stk.peek();
            	 stk.pop();
             }
         }
         System.out.println(result); 
    }
}