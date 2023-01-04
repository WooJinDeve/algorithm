import java.util.*;

class Solution {
    static final int INF = 1000000000;

    public int solution(int N, int[][] roads, int K) {
      int[][] graph = new int[N + 1][N + 1];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == j) continue;
                graph[i][j] = INF;
            }
        }

        for (int[] road : roads) {
            graph[road[0]][road[1]] = Math.min(graph[road[0]][road[1]], road[2]);
            graph[road[1]][road[0]] = Math.min(graph[road[1]][road[0]], road[2]);
        }

        for (int k = 1; k <= N; k++) { 	        // 경유지
            for (int i = 1; i <= N; i++) {      // 출발지
                for (int j = 1; j <= N; j++) {  //도착지
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
        return (int)Arrays.stream(graph[1])
                .filter(i -> i <= K)
                .count();
    }
}