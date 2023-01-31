import java.util.*;

class Solution {
    private static boolean[][] visited;
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static int[] solution(String[] maps) {
        List<Integer> answer = new LinkedList<>();
        int maxX = maps.length;
        int maxY = maps[0].length();

        map = new int[maxX][maxY];
        visited = new boolean[maxX][maxY];

        for (int i = 0; i < maxX; i++) {
            String mapInfo = maps[i];
            for (int j = 0; j < maxY; j++) {
                final char ch = mapInfo.charAt(j);
                map[i][j] = ch == 'X' ? -1 : ch - '0';
            }
        }

        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                if (map[i][j] != -1 && !visited[i][j]) {
                    final int value = dfs(i, j, maxX, maxY);
                    answer.add(value);
                }
            }
        }

        if (answer.isEmpty())
            return new int[]{-1};

        Collections.sort(answer);

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private static int dfs(int i, int j, int maxX, int maxY) {
        Queue<int[]> finder = new LinkedList<>();
        finder.add(new int[]{i,j});
        int summationDay = map[i][j];
        visited[i][j] = true;

        while (!finder.isEmpty()) {
            final int[] infos = finder.remove();
            for (int repeat = 0; repeat < 4; repeat++) {
                int x = infos[0] + dx[repeat];
                int y = infos[1] + dy[repeat];
                if (x >= 0 && x < maxX && y >= 0 && y < maxY) {
                    if (map[x][y] != -1 && !visited[x][y]){
                        finder.add(new int[]{x, y});
                        visited[x][y] = true;
                        summationDay += map[x][y];
                    }
                }
            }
        }
        return summationDay;
    }
}