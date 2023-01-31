import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k <= j + i; k++) {
                    int idx = k;
                    if (idx >= elements.length) {
                        idx -= elements.length;
                    }
                    sum += elements[idx];
                }
                answer.add(sum);
            }
        }

        return answer.size();
    }
}