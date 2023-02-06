import java.util.*;

class Solution {
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] map;
        boolean[][] visited;
        for (int i = 0; i < answer.length; i++) {
            map = new char[5][5];
            final String[] place = places[i];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    map[j][k] = place[j].charAt(k);
                }
            }

            boolean ok = true;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (!ok)
                        continue;

                    if (map[j][k] == 'P') {
                        visited = new boolean[5][5];
                        ok = bfs(map, visited, j, k);
                    }
                }
            }

            answer[i] = ok ? 1 : 0;
        }

        return answer;
    }


    private boolean bfs(final char[][] map, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 0});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            final int[] element = queue.remove();
            for (int k = 0; k < 4; k++) {
                int x = element[0] + dx[k];
                int y = element[1] + dy[k];
                if (x >= 0 && x < 5 && y >= 0 && y < 5 && !visited[x][y]) {
                    if (map[x][y] == 'P' && element[2] < 2)
                        return false;

                    if (map[x][y] == 'X' || element[2] == 2)
                        continue;

                    visited[x][y] = true;
                    queue.add(new int[]{x, y, element[2] + 1});
                }
            }
        }
        return true;
    }
}