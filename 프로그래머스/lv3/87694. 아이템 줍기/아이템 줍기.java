import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] map = new boolean[101][101];
        int[][] visit = new int[101][101];

        for (int[] rect : rectangle) {
            sketch(map, rect[0] * 2, rect[1] * 2 , rect[2] * 2, rect[3] * 2, true);
        }
        for (int[] rect : rectangle) {
            sketch(map, rect[0] * 2 + 1, rect[1] * 2 + 1, rect[2] * 2 - 1, rect[3] * 2 - 1, false);
        }

        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{characterX * 2, characterY * 2});
        visit[characterX * 2][characterY * 2] = 1;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while (!bfs.isEmpty()) {
            int[] e = bfs.remove();
            for (int i = 0; i < 4; i++) {
                int x = e[0] + dx[i];
                int y = e[1] + dy[i];
                if (x > 0 && x < 101 && y > 0 && y < 101 && visit[x][y] == 0 && map[x][y]){
                    bfs.add(new int[]{x, y});
                    visit[x][y] = visit[e[0]][e[1]] + 1;
                }
            }
        }

        return (visit[itemX * 2][itemY * 2] -1) / 2 ;
    }

    public void sketch(boolean[][] map, int x1, int y1, int x2, int y2, boolean sketch){
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                map[i][j] = sketch;
            }
        }
    }
}