class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m + 1][n + 1];
        final int MOD = 1_000_000_007;

        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = -1;
        }

        if (map[1][2] == 0)
            map[1][2] = 1;
        if (map[2][1] == 0)
            map[2][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == -1)
                    continue;
                if (map[i][j - 1] != -1)
                    map[i][j] = (map[i][j] + map[i][j-1]) % MOD;
                if (map[i-1][j] != -1)
                    map[i][j] = (map[i][j] + map[i-1][j]) % MOD;
            }
        }
        return map[m][n];
    }
}