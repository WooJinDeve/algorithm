import java.util.*;

class Solution {
    private static List<Integer>[] graph;
    private static int[] visited;
    private static int max;

    public static int solution(int n, int[][] edge) {
        graph = new List[n];
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int[] e : edge) {
            int x = e[0] - 1;
            int y = e[1] - 1;
            graph[x].add(y);
            graph[y].add(x);
        }

        bfs();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == max)
                answer++;
        }

        return answer;
    }

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 0;

        while (!queue.isEmpty()){
            Integer idx = queue.remove();
            List<Integer> g = graph[idx];
            for (Integer edge : g) {
                if (visited[edge] == -1){
                    visited[edge] = visited[idx] + 1;
                    queue.add(edge);
                    max = Math.max(max, visited[edge]);
                }
            }
        }
    }
}