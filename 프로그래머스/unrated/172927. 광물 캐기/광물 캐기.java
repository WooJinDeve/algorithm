import java.util.*;

class Solution {
    private int min = Integer.MAX_VALUE;
    private Map<String, List<Integer>> energy;

    public int solution(int[] picks, String[] minerals) {
        energy = new HashMap<>();
        energy.put("diamond", List.of(1, 5, 25));
        energy.put("iron", List.of(1, 1, 5));
        energy.put("stone", List.of(1, 1, 1));
        bfs(0, minerals.length, 0, picks, minerals);
        return min;
    }

    private void bfs(int depth, int N, int sum, int[] picks, String[] minerals){
        if (depth == N || picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0)
                continue;
            picks[i]--;
            int temp = 0;
            for (int j = depth; j < Math.min(depth + 5, N); j++) {
                temp += energy.get(minerals[j]).get(i);
            }
            bfs(Math.min(depth + 5, N), N, sum + temp, new int[]{picks[0], picks[1], picks[2]}, minerals);
            picks[i]++;
        }
    }
}