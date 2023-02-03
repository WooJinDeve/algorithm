import java.util.*;

class Solution {
    public int solution(int[] order) {
        int current = 1;
        int count = 0;
        Stack<Integer> sub = new Stack<>();

        Loop : for (int o : order) {
            if (current > order.length && sub.peek() != o){
                break;
            }

            if (!sub.isEmpty() && sub.peek() == o) {
                sub.pop();
                count++;
                continue;
            }

            while (current != o && current <= order.length) {
                sub.add(current);
                current++;
                if (current > order.length)
                    continue Loop;
            }

            count++;
            current++;
        }

        return count;
    }
}