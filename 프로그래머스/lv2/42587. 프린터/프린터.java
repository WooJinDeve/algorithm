import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(0, priorities.length)
                .forEach(i -> queue.add(priorities[i]));

        int count = 0;
        while (!queue.isEmpty()){
            Integer print = queue.remove();
            boolean ok = true;
            for (Integer compare : queue) {
                if (print < compare){
                    queue.add(print);
                    ok = false;
                    break;
                }
            }
            location--;
            if (ok) {
                count++;
                if (location == -1)
                    break;
            }

            location = location == -1 ? queue.size() - 1 : location;
        }

        return count;
    }
}