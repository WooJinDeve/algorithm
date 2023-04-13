import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int answer = 0;
        int rocket = 0;
        for(int[] target : targets) {
            if(rocket < target[0] + 1) {
                rocket = target[1];
                answer++;
            }
        }
        return answer;
    }
}