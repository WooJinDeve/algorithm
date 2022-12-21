import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<Data> queue = new LinkedList<>();
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }

        queue.add(new Data(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Data data = queue.remove();

            for (int i = 0; i < 4; i++) {
                int zx = data.x + dx[i];
                int zy = data.y + dy[i];
                if (zx >= 0 && zx < n && zy >= 0 && zy < m) {
                    if (visited[zx][zy] == -1 && maps[zx][zy] == 1) {
                        queue.add(new Data(zx, zy));
                        visited[zx][zy] = visited[data.x][data.y] + 1;
                    }
                }
            }
        }

        return visited[n-1][m-1];
    }
    
    static class Data{
        public int x;
        public int y;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}