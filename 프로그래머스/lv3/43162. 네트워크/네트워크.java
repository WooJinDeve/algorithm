import java.util.*;

class Solution {
    private boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                ans++;
                bfs(i, n, computers);
            }
        }
        return ans;
    }

    private void bfs(int i, int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.add(i);

        while (!queue.isEmpty()){
            Integer idx = queue.remove();

            for (int j = 0; j < n; j++) {
                if (computers[idx][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
}