import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        String[] medal = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] answer = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            map.put(score[i], i);
        }

        int value = 0;
        while (!pq.isEmpty()) {
            Integer idx = map.get(pq.remove());
            value++;
            if (value <= 3){
                answer[idx] = medal[value - 1];
                continue;
            }
            answer[idx] = value + "";
        }
        return answer;
    }
}