import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> map = new HashMap<>();

        for (String key : keymap) {
            String[] k = key.split("");
            for (int i = 0; i < k.length; i++) {
                if (map.containsKey(k[i])) {
                    map.put(k[i], Math.min(map.get(k[i]), i + 1));
                } else {
                    map.put(k[i], i + 1);
                }

            }
        }

        return Arrays.stream(targets)
                .mapToInt(target -> {
                    int sum = 0;
                    for (String key : target.split("")) {
                        if (!map.containsKey(key))
                            return -1;
                        sum += map.get(key);
                    }
                    return sum;
                }).toArray();
    }
}