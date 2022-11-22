import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
    int[][] points = new int[][]{{3, 0}, {2, 0}, {1, 0}, {0, 0}, {0, 1}, {0, 2}, {0, 3}};
        char[] indicators = new char[]{'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> indctCounter = toindctCounter();
        for (int i = 0; i < survey.length; i++) {
            char A = survey[i].charAt(0);
            char B = survey[i].charAt(1);
            int[] point = points[choices[i] - 1];
            indctCounter.put(A, indctCounter.get(A) + point[0]);
            indctCounter.put(B, indctCounter.get(B) + point[1]);
        }

        for (int i = 0; i < indicators.length; i += 2) {
            Integer typeA = indctCounter.get(indicators[i]);
            Integer typeB = indctCounter.get(indicators[i + 1]);
            if(typeA == typeB){
                if (indicators[i] > indicators[i + 1])
                    sb.append(indicators[i+1]);
                else
                    sb.append(indicators[i]);
                continue;
            }

            if (typeA > typeB)
                sb.append(indicators[i]);
            else
                sb.append(indicators[i + 1]);
        }

        return sb.toString();
    }
    
    public Map<Character, Integer> toindctCounter() {
        Map<Character, Integer> indctCounter = new HashMap<>();
        indctCounter.put('R', 0);
        indctCounter.put('T', 0);
        indctCounter.put('C', 0);
        indctCounter.put('F', 0);
        indctCounter.put('J', 0);
        indctCounter.put('M', 0);
        indctCounter.put('A', 0);
        indctCounter.put('N', 0);
        return indctCounter;
    }
}