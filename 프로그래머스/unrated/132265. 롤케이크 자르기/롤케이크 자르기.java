import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;

        HashSet<Integer> left = new HashSet<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        left.add(topping[0]);
        for (int i = 1;i < size; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 1;i < size; i++) {
            if (left.size() == right.size())
                answer++;

            int key = topping[i];
            
            left.add(key);
            right.put(key, right.get(key) - 1);
            if (right.get(key) == 0) {
                right.remove(key);
            }
        }

        return answer;
    }
}