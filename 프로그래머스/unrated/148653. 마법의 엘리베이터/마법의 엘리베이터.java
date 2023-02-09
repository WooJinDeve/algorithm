import java.util.*;

class Solution {
    public int solution(int storey) {
        return bfs(storey);

    }
    
    private static int bfs(int n) {
        PriorityQueue<Integer> answer = new PriorityQueue<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] element = queue.remove();
            int storey = element[0];
            int move = element[1];

            if (storey == 0) {
                answer.add(move);
                continue;
            }

            int temp = storey % 10;
            int key1 = (storey + temp) / 10;
            int key2 = (storey - temp) / 10;
            queue.add(new int[]{key1, move + (10 - temp)});
            queue.add(new int[]{key2, move + temp});
        }

        return answer.peek();
    }
}