import java.util.*;

class Solution {
    private boolean[] visited;
    private ArrayList[] tree;
    
    public int solution(int n, int[][] wires) {
        int min = n;
        for (int k = 0; k < wires.length; k++) {
            visited = new boolean[n];
            tree = new ArrayList[n];
            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < wires.length; i++) {
                int[] wire = wires[i];
                x = wire[0] - 1;
                y = wire[1] - 1;
                if (k == i) {
                    continue;
                }
                tree[x].add(y);
                tree[y].add(x);
            }

            int count = bfs(x);
            int result = Math.abs(count - (n - count));
            min = Math.min(min, result);
        }
        return min;
    }
    
    private int bfs(int idx){
        int count = 1;
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        queue.add(tree[idx]);
        visited[idx] = true;
        while (!queue.isEmpty()){
            ArrayList<Integer> list = queue.remove();
            for (Integer l : list) {
                if (!visited[l]) {
                    count++;
                    queue.add(tree[l]);
                    visited[l] = true;
                }
            }
        }

        return count;
    }
}