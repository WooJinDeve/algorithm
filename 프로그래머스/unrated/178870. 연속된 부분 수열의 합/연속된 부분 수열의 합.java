class Solution {
    public int[] solution(int[] sequence, int k) {
                int n = sequence.length;

        int[] answer = new int[2];
        
        int min = n;

        int sum = 0;
        int start = 0;
        int end = 0;

        while (start < n) {
            if (sum > k || end == n) {
                sum -= sequence[start];
                start++;
            } else {
                sum += sequence[end];
                end++;
            }
            
            if (sum == k && min > end - start - 1){
                answer[0] = start;
                answer[1] = end - 1;
                min = end - start - 1;
            }
        }

        return answer;
    }
}