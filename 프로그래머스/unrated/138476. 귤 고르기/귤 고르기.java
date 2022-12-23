import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int key : tangerine) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> entry : collect) {
            if (k > 0) {
                k -= entry.getValue();
                count++;
            }else
                break;
        }
        return count;
    }
}