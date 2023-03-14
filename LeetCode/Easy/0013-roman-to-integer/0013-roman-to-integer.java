import java.util.*;

class Solution {
    
    private int answer = 0;
    
    public int romanToInt(String s) {
        Map<String, Integer> compositeRoman = initializeIompositeRoman();
        Map<String, Integer> roman = initializeRoman();
        
        s = convertToCompositeRoman(s, compositeRoman);
        if(s.equals(""))
            return answer;
        
        for(String r : s.split("")){
            answer += roman.get(r);
        }
        return answer;
    }
    
    private Map<String, Integer> initializeIompositeRoman(){
        Map<String, Integer> roman = new HashMap<>();
        roman.put("IV", 4);
        roman.put("IX", 9);
        roman.put("XL", 40);
        roman.put("XC", 90);
        roman.put("CD", 400);
        roman.put("CM", 900);
        return roman;
    } 
    
    private Map<String, Integer> initializeRoman(){
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        return roman;
    }
    
    private String convertToCompositeRoman(String str, Map<String, Integer> compositeRoman){
         for(String key : compositeRoman.keySet()){
                while(str.contains(key)){
                    answer += compositeRoman.get(key);
                    str = str.replace(key, "");
                }
         }
        return str;
    }
}