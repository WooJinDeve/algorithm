import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(s.split(" "))
                .map(s1 -> firstCharUpperCase(s1))
                .collect(Collectors.toList())
                .forEach(sb::append);
        
        if (s.charAt(s.length()-1) == ' ')
            return sb.toString();
        return sb.substring(0, sb.length() - 1);
    }
    
    public String firstCharUpperCase(String str){
      if (str.isEmpty())
            return " ";
        String first = str.toUpperCase().substring(0, 1);
        String last = str.toLowerCase().substring(1, str.length());
        return first + last + " ";
    }
}