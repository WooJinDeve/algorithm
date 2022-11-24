import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<Integer> result = Arrays.stream(s.split(" "))
                .filter(s1 -> !s1.isEmpty())
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int maxIndex = result.size() - 1;
        return result.get(0) + " " + result.get(maxIndex);
    }
}