import java.util.*;

class Solution {

    public static int[] solution(String s) {
        int[] location = new int[s.length()];
        int[] alpha = new int[26];

        Arrays.fill(alpha, -1);
        for (int i = 0; i < s.length(); i++) {
            if (alpha[s.charAt(i) - 'a'] > -1) {
                location[i] = i - alpha[s.charAt(i) - 'a'];
                alpha[s.charAt(i) - 'a'] = i;
                continue;
            }
            alpha[s.charAt(i) - 'a'] = i;
            location[i] = -1;
        }
        return location;
    }
}