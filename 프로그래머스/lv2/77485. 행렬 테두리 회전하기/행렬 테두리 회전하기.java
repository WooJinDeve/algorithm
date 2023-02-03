class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = (i * columns) + (j + 1);
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = rotation(queries[i], map);
        }

        return answer;
    }

    private int rotation(int[] queries, int[][] map){
        int x1 = queries[0] - 1;
        int y1 = queries[1] - 1;
        int x2 = queries[2] - 1;
        int y2 = queries[3] - 1;


        int temp = map[x1][y1];
        int min = temp;

        for(int i = x1; i < x2; i++){
            map[i][y1] = map[i + 1][y1];
            min = Math.min(min, map[i][y1]);
        }

        for(int j = y1; j < y2; j++){
            map[x2][j] = map[x2][j + 1];
            min = Math.min(min, map[x2][j]);
        }

        for(int i = x2; i > x1; i--){
            map[i][y2] = map[i - 1][y2];
            min = Math.min(min, map[i][y2]);
        }

        for(int j = y2; j > y1 + 1; j--){
            map[x1][j] = map[x1][j - 1];
            min = Math.min(min, map[x1][j]);
        }
        map[x1][y1 + 1] = temp;

        return min;
    }
}