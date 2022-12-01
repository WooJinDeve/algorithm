class Solution {
    public int solution(int n) {
        long[] F = new long[n+1];
        F[0] = 0L;
        F[1] = 1L;
        for (int i = 2; i <= n; i++) {
            F[i] = (F[i-1] + F[i-2]) % 1234567;
        }
        return (int)F[n];
    }
}