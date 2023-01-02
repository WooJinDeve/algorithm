import java.util.*;

class Solution {
    public int[] solution(int k, int[] scores){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        
        for (int score : scores) {
            queue.add(score);
            while (queue.size() > k) {
                queue.remove();
            }
            result.add(queue.peek());
        }
        
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}