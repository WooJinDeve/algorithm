import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private Map<String, Integer> toMap = new HashMap<>();
    private Map<Integer, Integer> count = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> ans = new ArrayList<>();
        for (String order : orders) {
            for (int c : course) {
                char[] orderChar = order.toCharArray();
                Arrays.sort(orderChar);
                insertToMap(c, 0, String.valueOf(orderChar), "", 0);
            }
        }

        for (int c : course) {
            Integer compare = count.get(c);
            if (compare != null && compare >= 2) {
                List<String> order = toMap.keySet().stream()
                        .filter(k -> k.length() == c)
                        .filter(k -> Objects.equals(toMap.get(k), compare))
                        .collect(Collectors.toList());
                ans.addAll(order);
            }
        }

        Collections.sort(ans);
        return ans.toArray(new String[0]);
    }

    private void insertToMap(int M, int depth, String text, String ans, int k) {
        if (M == depth){
            toMap.put(ans, toMap.getOrDefault(ans, 0) + 1);
            if (count.getOrDefault(M, 0) < toMap.get(ans)){
                count.put(M, toMap.get(ans));
            }
            return;
        }

        for (int i = k; i < text.length(); i++) {
            insertToMap(M, depth + 1, text, ans + text.charAt(i), i+1);
        }
    }
}