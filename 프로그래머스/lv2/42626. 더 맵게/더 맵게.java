import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        IntStream.range(0, scoville.length)
                .forEach(i -> queue.add(scoville[i]));

        int count = 0;
        while (!queue.isEmpty() && queue.size() >= 2){
            Integer first = queue.remove();
            Integer second  = queue.remove();

            if (first >= K){
                queue.add(first);
                queue.add(second);
                break;
            }

            queue.add(first + (second * 2));
            count++;
        }

        if (queue.isEmpty() || queue.peek() < K)
            return -1;
        return count;
    }
}