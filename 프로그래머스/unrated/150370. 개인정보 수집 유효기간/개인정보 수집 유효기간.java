import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = initMap(terms);
        List<Integer> result = new ArrayList<>();

        int todayDate = convertToTime(today, map);
        for (int i = 0; i < privacies.length; i++) {
            if (convertToTime(privacies[i], map) <= todayDate)
                result.add(i + 1);
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int convertToTime(String time, Map<String, Integer> map){
        int year=Integer.parseInt(time.substring(0, 4));//년
        int month=Integer.parseInt(time.substring(5, 7));//월
        int day=Integer.parseInt(time.substring(8,10));//일
        if (time.length() > 10){
            month += map.get(time.substring(11,12));
        }
        return (year*12*28)+(month*28)+(day-1);
    }


    private Map<String, Integer> initMap(String[] terms) {
        return Arrays.stream(terms)
                .collect(Collectors.toMap(m -> m.split(" ")[0],
                        m -> Integer.parseInt(m.split(" ")[1])));
    }
}