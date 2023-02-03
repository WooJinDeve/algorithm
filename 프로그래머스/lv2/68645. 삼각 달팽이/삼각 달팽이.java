import java.util.*;

class Solution {
    public static int[] solution(int n) {
        int[][] map = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                map[x][y] = num++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0)
                    result.add(map[i][j]);
            }
        }
        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}