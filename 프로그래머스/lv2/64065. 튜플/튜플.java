import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String str = convertToBracket(s);
        for (String s1 : str.split(",")) {
            int key = Integer.parseInt(s1);
            if (map.containsKey(key)){
                map.put(key, map.get(key) + 1);
                continue;
            }
            map.put(key, 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(((o1, o2) -> map.get(o2).compareTo(map.get(o1))));

        return keySet.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public String convertToBracket(String s){
        return s.replace("{", "")
                .replace("}", "");
    }
}