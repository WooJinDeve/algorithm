class Solution {
    public int solution(int n) {
        final int DIV = 1_000_000_007;

        long[] tiling = new long[n+1];
        tiling[0] = 1;
        tiling[1] = 1;
        tiling[2] = 2;

        for (int i = 3; i <= n; i++) {
            tiling[i] = (tiling[i-1] + tiling[i-2]) % DIV;
        }

        return (int)tiling[n];
    }
}