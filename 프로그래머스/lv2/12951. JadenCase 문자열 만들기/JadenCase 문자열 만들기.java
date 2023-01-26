import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s){
        StringBuilder sb = new StringBuilder();
        Arrays.stream(s.split(" "))
                .map(str -> convertToJadenCase(str))
                .collect(Collectors.toList())
                .forEach(sb::append);
        if (s.charAt(s.length() - 1) == ' ')
            return sb.toString();
        return sb.substring(0, sb.length() - 1);
    }

    private String convertToJadenCase(String s){
        if (s.isEmpty())
            return " ";
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase() + " ";
    }
}