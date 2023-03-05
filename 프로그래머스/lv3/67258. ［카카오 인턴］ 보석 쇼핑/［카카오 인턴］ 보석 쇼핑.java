import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> store = new HashMap<>();
        Set<String> distinctGems = Arrays.stream(gems)
                .collect(Collectors.toSet());
        int N = distinctGems.size();

        int left = 0;
        int right = 0;
        int size = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < gems.length) {
            if (store.size() != N && right < gems.length) {
                store.put(gems[right], store.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (store.size() == N && size > right - left){
                answer[0] = left + 1;
                answer[1] = right;
                size = right - left;
            }

            if (store.size() == N){
                store.put(gems[left], store.get(gems[left]) - 1);
                if (store.get(gems[left]) == 0) {
                    store.remove(gems[left]);
                }
                left++;
            }

            if (store.size() != N && right == gems.length)
                break;
        }

        return answer;
    }
}