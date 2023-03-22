import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 100_000_009;
        int answer = Integer.MAX_VALUE;


        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for(int[] fare : fares){
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }

        for(int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i == k) continue;
                    
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(graph[s][i] != INF && graph[i][a] != INF && graph[i][b] != INF)
                answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        
        return answer;
    }
}