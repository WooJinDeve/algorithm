import java.util.*;

class Solution {
    static int[][][] dp;
    static int[] dx = {0,-1,1,0};
    static int[] dy = {-1,0,0,1};
    static int N;
    static int answer;

    public static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        N = board.length;
        dp = new int[N][N][4];

        for(int i=0; i<N; i++)
            for (int j=0; j<N; j++)
                for(int k=0; k<4; k++)
                    dp[i][j][k] = Integer.MAX_VALUE;

        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][0][3] = 0;

        bfs(0,0, board);

        return answer;
    }

    private static void bfs(int x, int y, int[][] board) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y, 0});

        while(!deque.isEmpty()) {
            int[] pos = deque.poll();
            x = pos[0]; y = pos[1];
            int preDir = pos[2];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1)
                    continue;

                int newCost = dp[x][y][preDir];
                if ((x == 0 && y == 0) || i == preDir) {
                    newCost += 100;
                } else {
                    newCost += 600;
                }

                if(dp[nx][ny][i] >= newCost) {
                    dp[nx][ny][i] = newCost;
                    deque.add(new int[]{nx, ny, i});
                }

                if(nx == N-1 && ny == N-1) {
                    answer = Math.min(newCost, answer);
                }
            }
        }
    }
}