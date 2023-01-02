import java.util.*;


class Solution {
private static boolean[][] visited;
    private static char[][] map;
    private static int MAX_ROW;
    private static int MAX_COLUMN;

    public int solution(int m, int n, String[] boards) {
        map = new char[m][n];
        MAX_ROW = m;
        MAX_COLUMN = n;

        int ans = 0;

        for (int i = 0; i < boards.length; i++) {
            String board = boards[i];
            for (int j = 0; j < board.length(); j++) {
                map[i][j] = board.charAt(j);
            }
        }

        //찾기
        while (true){
            visited = new boolean[m][n];
            for (int i = 0; i + 1 < m; i++) {
                for (int j = 0; j + 1 < n; j++) {
                    char ch = map[i][j];
                    if (ch >= 'A'&& ch <= 'Z' && checkAndVisit(i, j, ch)) {
                        checkAndVisit(i, j + 1, ch);
                        checkAndVisit(i + 1, j, ch);
                        checkAndVisit(i + 1, j + 1, ch);
                    }
                }
            }

            ArrayList<Character>[] list = new ArrayList[n];
            for(int i = 0; i < n; i++)
                list[i] = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = m - 1; j >= 0; j--){
                    if(!visited[j][i]){
                        list[i].add(map[j][i]);
                    }
                }
            }


            boolean ok = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]){
                        ok = true;
                        ans++;
                    }
                }
            }

            if (!ok){
                break;
            }

            map = new char[m][n];
            for(int i = 0; i < n; i++){
                for(int j = m - 1; j >= 0; j--){
                    if(list[i].size() > 0) {
                        map[j][i] = list[i].get(0);
                        list[i].remove(0);
                    }
                }
            }
        }
        return ans;
    }

    private boolean checkAndVisit(int i, int j, char ch) {
        if (i >= 0 && i + 1 < MAX_ROW && j >= 0 && j + 1< MAX_COLUMN) {
            if (ch == map[i][j + 1] && ch == map[i + 1][j] && ch == map[i + 1][j + 1]) {
                visited[i][j] = true;
                visited[i][j + 1] = true;
                visited[i + 1][j + 1] = true;
                visited[i + 1][j] = true;
                return true;
            }
        }
        return false;
    }
}