class Solution {
    public long solution(int[] sequence) {
        long[] plus = new long[sequence.length];
        long[] minus = new long[sequence.length];

        plus[0] = sequence[0];
        minus[0] = -sequence[0];

        long answer = Math.max(plus[0], minus[0]);
        for (int i = 1; i < sequence.length; i++) {
            if (i % 2 == 0){
                plus[i] = Math.max(plus[i-1] + sequence[i], sequence[i]);
                minus[i] = Math.max(minus[i-1] - sequence[i], -sequence[i]);
            }else {
                plus[i] = Math.max(plus[i-1] - sequence[i], -sequence[i]);
                minus[i] = Math.max(minus[i-1] + sequence[i], sequence[i]);
            }
            answer = Math.max(answer, plus[i]);
            answer = Math.max(answer, minus[i]);
        }
        return answer;
    }
    
}