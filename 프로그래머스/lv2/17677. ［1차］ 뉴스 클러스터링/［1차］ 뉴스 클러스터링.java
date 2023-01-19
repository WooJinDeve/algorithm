import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> map1 = new HashMap<>(); 
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>(); 
        
        isAlphabetChecking(str1, map1, set);
        isAlphabetChecking(str2, map2, set);
        
        int intersection = 0, union = 0;
        for(String s : set)
            union += Math.max(map1.getOrDefault(s, 0) , map2.getOrDefault(s, 0));

        for(String s : map2.keySet()) 
            if(map1.containsKey(s))
                intersection += Math.min(map1.get(s), map2.get(s));


        if(union == 0) return 65536;
        return intersection * 65536 / union;
    }

    private void isAlphabetChecking(String str1, Map<String, Integer> map1, Set<String> set) {
        for(int i = 0; i < str1.length() - 1 ; i ++){
            String temp = str1.substring(i, i + 2);
            if(Character.isAlphabetic(temp.charAt(0)) 
                    && Character.isAlphabetic(temp.charAt(1))){
                map1.put(temp, map1.getOrDefault(temp, 0) + 1);
                set.add(temp);
            }
        }
    }
}