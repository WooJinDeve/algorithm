import java.util.*;

class Solution {
    boolean solution(String s) {
        Queue<Integer> queue = new LinkedList();
        
        for (char c : s.toCharArray()) {
            if(c == ')'){
                if(queue.isEmpty())
                    return false;
                queue.remove();
            }else 
                queue.add(1);
        }
        
        return queue.isEmpty()? true : false;
    }
}