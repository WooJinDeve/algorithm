import java.util.*;

class Solution {
      public static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int cam = Integer.MIN_VALUE;

        for(int[] route : routes) {
            if(cam < route[0]) {
                cam = route[1];
                answer++;
            }
        }

        return answer;
    }
}