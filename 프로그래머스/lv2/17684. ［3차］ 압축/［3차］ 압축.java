import java.util.*;

class Solution {
    public int[] solution(String msg){
        int idx = 27;
        Map<String, Integer> lzwMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            lzwMap.put(String.valueOf((char)(65 + i)), i + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            int print = 0;
            for (int j = i; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                String key = sb.toString();
                if (lzwMap.containsKey(key)) {
                    print = lzwMap.get(key);
                    i = j;
                    continue;
                }
                lzwMap.put(key, idx++);
                break;
            }
            result.add(print);
        }

        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}