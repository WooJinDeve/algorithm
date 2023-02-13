class Solution {

    public int solution(int[][] triangle) {
         int[][] result = new int[triangle.length][triangle.length];
        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            System.arraycopy(triangle[i], 0, result[i], 0, triangle[i].length);
        }

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                result[i][j] = result[i][j] + Math.max(result[i - 1][j], result[i - 1][Math.max(0, j - 1)]);
                answer = Math.max(result[i][j], answer);
            }
        }

        return answer;
    }
}