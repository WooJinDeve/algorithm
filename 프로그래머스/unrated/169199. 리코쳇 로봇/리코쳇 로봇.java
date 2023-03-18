import java.util.*;

class Solution {
    private int[][] map;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int solution(String[] board) {
        int startX = 0;
        int startY = 0;
        int goalX = 0;
        int goalY = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R'){
                    startX = i; startY = j;
                }
                if (board[i].charAt(j) == 'G'){
                    goalX = i; goalY = j;
                }
            }
        }

        map = new int[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(map[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        map[startX][startY] = 0;
        while (!queue.isEmpty()){
            int[] e = queue.remove();
            if (e[0] == goalX && e[1] == goalY) return map[e[0]][e[1]];
            for (int i = 0; i < 4; i++) {
                int x = e[0] + dx[i];
                int y = e[1] + dy[i];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length() && board[x].charAt(y) != 'D'){
                    while (x + dx[i]>= 0 && x + dx[i] < board.length && y + dy[i] >= 0 && y + dy[i] < board[0].length() && board[x + dx[i]].charAt(y + dy[i] ) != 'D') {
                        x += dx[i];
                        y += dy[i];
                    }
                    if (map[x][y] == -1){
                        map[x][y] = map[e[0]][e[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
        return -1;
    }
}