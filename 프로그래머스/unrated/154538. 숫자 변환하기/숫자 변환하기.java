import java.util.*;

class Solution {
    static final int MAX_IDX = 1_000_001 * 3;
    static boolean[] visited = new boolean[MAX_IDX];

    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        while (!queue.isEmpty()) {
            final int[] element = queue.remove();
            if (visited[element[0]] || element[0] > y)
                continue;

            visited[element[0]] = true;

            if (element[0] == y) {
                return element[1];
            }

            queue.add(new int[]{element[0] + n, element[1] + 1});
            queue.add(new int[]{element[0] * 2, element[1] + 1});
            queue.add(new int[]{element[0] * 3, element[1] + 1});
        }
        return -1;
    }
}