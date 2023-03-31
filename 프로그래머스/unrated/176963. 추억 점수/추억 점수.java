import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> valueMap = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            valueMap.put(name[i], yearning[i]);
        }


        for(int i = 0; i < photo.length; i++){
            answer[i] = Arrays.stream(photo[i])
                    .filter(valueMap::containsKey)
                    .mapToInt(valueMap::get)
                    .sum();
        }

        return answer;
    }
}