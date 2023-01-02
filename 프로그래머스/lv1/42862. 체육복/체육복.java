import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
         int count = lost.length;
        boolean[] visited = new boolean[reserve.length];
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = 0;
                    visited[j] = true;
                    count--;
                    break;
                }
            }
            for (int k : reserve) {
                if (lost[i] == k) {
                    lost[i] = 0;
                    break;
                }
            }
        }

        for (int l : lost) {
            if (l == 0)
                continue;

            for (int i = 0; i < reserve.length; i++) {
                if (visited[i])
                    continue;

                if (l - 1 == reserve[i] || l + 1 == reserve[i]) {
                    visited[i] = true;
                    count--;
                    break;
                }
            }
        }

        return n - count;
    }
}