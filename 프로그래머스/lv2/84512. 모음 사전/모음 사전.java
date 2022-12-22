import java.util.HashMap;

class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] cha = {781,156,31,6,1};
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 0);
        map.put("E", 1);
        map.put("I", 2);
        map.put("O", 3);
        map.put("U", 4);

        String[] word_arr = word.split("");
        answer += word_arr.length;

        for(int i=0; i<word_arr.length; i++) {
            answer += cha[i]*map.get(word_arr[i]);
        }
        return answer;
    }
}