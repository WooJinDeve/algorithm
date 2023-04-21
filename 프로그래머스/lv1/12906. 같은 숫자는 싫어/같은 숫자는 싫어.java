import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new LinkedList<>();
        
        for(int i : arr){
            if(stack.isEmpty() || stack.peek() != i) {
                answer.add(i);
                stack.add(i);
            }
        }
       
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}