import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int k, int[] enemy){
        return defence(n, k, enemy);
    }
    
    public int defence(int n, int k, int[] enemy){
        int left = 0;
        int right = enemy.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (possible(mid, n, k, enemy)) left = mid + 1;
            else right = mid;
        }

        return left;
    }

    private boolean possible(int mid, int n, int k, int[] enemy) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        IntStream.range(0, mid+1).forEach(i -> queue.add(enemy[i]));


        while (!queue.isEmpty()) {
            Integer en = queue.poll();

            if (n >= en) {
                n -= en;
                continue;
            }

            queue.add(en);

            return k >= queue.size();
        }
        return true;
    }
}