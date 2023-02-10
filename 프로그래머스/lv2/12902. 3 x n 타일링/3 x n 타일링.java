class Solution {
     public int solution(int n) {
        final int mod = 1_000_000_007;
        long[] answer = new long[n + 1];

        answer[0] = 1;
        answer[2] = 3;
        for (int i = 4; i <= n; i++) {
            answer[i] = (answer[i - 2] * 4 % mod - answer[i - 4] % mod + mod) % mod;
        }

        return (int)answer[n];
    }
}