import java.util.*;

class Solution {
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt(o1 -> o1[2]));

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {
            if (find(parent, cost[0]) != find(parent, cost[1])) {
                union(parent, cost[0], cost[1]);
                answer += cost[2];
            }
        }
        return answer;
    }

    private static int find(int[] parent, int x){
        if (parent[x] == x)
            return x;
        return find(parent, parent[x]);
    }

    private static boolean union(int[] parent, int x, int y){
        int a = find(parent, x);
        int b = find(parent, y);

        if (a == b)
            return false;

        if (a <= b) parent[b] = a;
        else parent[a] = b;
        return true;
    }
}