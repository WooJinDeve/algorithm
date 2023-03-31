import java.util.*;
import java.util.Map.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = IntStream.range(0, name.length)
                .mapToObj(i -> Map.entry(name[i], yearning[i]))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        return Arrays.stream(photo)
                .mapToInt(p -> Arrays.stream(p)
                        .filter(map::containsKey)
                        .mapToInt(map::get)
                        .sum())
                .toArray();
    }
}