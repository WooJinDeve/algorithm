import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
          Deque<Integer> deque = new ArrayDeque<>();
        int answer = 0;

        for (int s : section) {
            if (deque.isEmpty()) {
                deque.add(s);
                continue;
            }

            if (m >= s - deque.peekFirst() + 1){
                deque.add(s);
            }else {
                deque.clear();
                deque.add(s);
                answer++;
            }
        }

        if (!deque.isEmpty())
            answer++;

        return answer;
    }
}