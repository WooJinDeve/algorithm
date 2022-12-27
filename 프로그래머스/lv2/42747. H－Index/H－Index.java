import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int last = citations[citations.length - 1];
        int max = 0;

        for (int h = 0; h <= last; h++) {
            int up, down;
            up = down = 0;
            for (int citation : citations) {
                if (citation >= h) {
                    up++;
                    continue;
                }
                down++;
            }
            if (up >= h && (up + down) == citations.length)
                max = h;   
        }
        return max;
    }
}