import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largestQueue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(nums).forEach(largestQueue::add);
        
        int answer = 0;
        for(int i = 0; i < k; i++){
            answer = largestQueue.poll();
        }
        return answer;
    }
}