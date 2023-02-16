import java.util.*;

class Solution {
    private static char[][] map;
    private static int[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0,1, -1};
    private static int N;
    private static int M;

    public static int solution(String[] maps) {
        int startX = 0, startY = 0;
        int exitX = 0, exitY = 0;
        int leverX = 0, leverY = 0;

        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S'){
                    startX = i;
                    startY = j;
                }else if(c == 'E'){
                    exitX = i;
                    exitY = j;
                } else if (c == 'L') {
                    leverX = i;
                    leverY = j;
                }
                map[i][j] = c;
            }
        }

        int answer = 0;

        bfs(startX, startY, 'L');
        if (visited[leverX][leverY] == 0) {
            return -1;
        }
        answer += visited[leverX][leverY];
        visited = new int[N][M];

        bfs(leverX, leverY, 'E');
        if (visited[exitX][exitY] == 0) {
            return -1;
        }
        answer += visited[exitX][exitY];

        return answer;
    }

    private static void bfs(int i, int j, char target){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = 0;

        while (!queue.isEmpty()) {
            int[] e = queue.remove();
            for (int k = 0; k < 4; k++) {
                int x = e[0] + dx[k];
                int y = e[1] + dy[k];
                if (x >= 0 && x < N && y >= 0 && y < M && visited[x][y] == 0 && map[x][y] != 'X') {
                    visited[x][y] = visited[e[0]][e[1]] + 1;
                    queue.add(new int[]{x, y});
                    if (map[x][y] == target)
                        return;
                }
            }
        }
    }
}