import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
       Set<String> distinctEng = new HashSet<>();
        String preEng = words[0];
        distinctEng.add(preEng);

        int x = 0;
        int y = 0;
        boolean ok = false;

        for (int i = 1; i < words.length; i++) {
            if (preEng.charAt(preEng.length() - 1) != words[i].charAt(0) || distinctEng.contains(words[i])){
                ok = true;
                break;
            }

            distinctEng.add(words[i]);
            preEng = words[i];
        }

        if (ok){
            // 4
            int length = distinctEng.size() + 1;
            x = length % n == 0? n : length % n;
            y = length % n == 0? length / n : length / n + 1;
        }
        return new int[]{x, y};
    }
}