import java.util.*;

class Solution {
    private boolean[][] visited;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int[] solution(int m, int n, int[][] picture) {
        Map<Integer, Integer> store = new HashMap<>();
        visited = new boolean[m][n];
        int[] answer = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    answer[1] = Math.max(answer[1], dfs(i, j, m, n, picture[i][j], picture));
                    answer[0]++;
                }
            }
        }

        return answer;
    }

    private int dfs(int i, int j, int m, int n, int key, int[][] picture) {
        Queue<int[]> finder = new LinkedList<>();
        finder.add(new int[]{i, j});
        visited[i][j] = true;
        int count = 1;

        while (!finder.isEmpty()) {
            int[] e = finder.remove();
            for (int k = 0; k < 4; k++) {
                int x = e[0] + dx[k];
                int y = e[1] + dy[k];
                if (x >= 0 && x < m && y >= 0 && y < n && picture[x][y] == key && !visited[x][y]) {
                    visited[x][y] = true;
                    finder.add(new int[]{x, y});
                    count++;
                }
            }
        }

        return count;
    }
}