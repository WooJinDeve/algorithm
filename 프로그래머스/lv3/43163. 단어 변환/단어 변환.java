class Solution {
    private int min = 0;
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return min;
    }

    public void dfs(String begin, String target, String[] words, int depth) {
        if (begin.equals(target)) {
            if (min == 0) 
                min = depth;
            min = Math.min(min, depth);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isPossible(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPossible(String begin, String compare) {
        int count = 0;
        for (int j = 0; j < compare.length(); j++) {
            if (begin.charAt(j) != compare.charAt(j)) 
                count++;
        }
        return count == 1;
    }
}