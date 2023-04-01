import java.util.*;

class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardQueue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cardQueue2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> goalQueue = new LinkedList<>(Arrays.asList(goal));

        while (!goalQueue.isEmpty()){
            String g = goalQueue.poll();

            if (!cardQueue1.isEmpty() && cardQueue1.peek().equals(g)){
                cardQueue1.poll();
                continue;
            }

            if (!cardQueue2.isEmpty() && cardQueue2.peek().equals(g)){
                cardQueue2.poll();
                continue;
            }

            return "No";
        }

        return "Yes";
    }
}