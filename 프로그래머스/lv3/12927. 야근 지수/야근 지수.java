import java.util.*;

class Solution {
    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(works).forEach(pq::add);

        while (n != 0) {
            Integer element = pq.poll();
            pq.add(element == 0 ? element : element - 1);
            n--;
        }

        long answer = 0;
        for (Integer element : pq) {
            answer += (long) element * element;
        }
        return answer <= n ? 0 : answer;
    }
}