import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
 int count = 0;

        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int person : people) {
            deque.add(person);
        }

        while (!deque.isEmpty()){
            Integer first = deque.peekFirst();
            Integer last = deque.peekLast();

            if (first + last <= limit){
                count++;
                deque.pollFirst();
                deque.pollLast();
            }else {
                count++;
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() > limit/2)
                break;
        }

        count += deque.size();

        return count;
    }
}