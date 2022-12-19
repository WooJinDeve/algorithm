class Solution {
    private boolean[] visited;
    private int max = 0;

    public int solution(int k, int[][] dungeons){
        visited = new boolean[dungeons.length];
        btk(0, 0, k, dungeons);
        return max;
    }

    private void btk(int count, int depth, int health, int[][] dungeons){
        max = Math.max(max, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && health >= dungeons[i][0]){
                visited[i] = true;
                btk(count + 1, depth + 1, health - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}