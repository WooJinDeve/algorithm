import java.util.Arrays;

class Solution {
     public static int[] solution(int n, int s) {
         int[] answer = new int[n];
        Arrays.fill(answer, s / n);
        
        if (n > s) return new int[]{-1};
        if (s % n == 0) return answer;
        

        for (int i = 0; i < s % n; i++) {
            answer[i] += 1;
        }
        Arrays.sort(answer);
        return answer;
    }
}