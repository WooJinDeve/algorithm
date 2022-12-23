import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> strNumbers = new ArrayList<>();
        for (int number : numbers) {
            strNumbers.add(String.valueOf(number));
        }

        strNumbers.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strNumbers.get(0).equals("0"))
            return "0";

        return String.join("", strNumbers);
    }
}