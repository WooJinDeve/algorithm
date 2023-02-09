class Solution {
    private int[] vx = new int[12];
    private int[] vy = new int[12];

    public int solution(int n) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += go(0, i, n);
        }
        return answer;
    }

    public int go(int x, int y, int n) {
        for (int i = 0; i < x; i++) {
            if (x == vx[i]) return 0;
            if (y == vy[i]) return 0;
            if (Math.abs(x - vx[i]) == Math.abs(y - vy[i])) return 0;
        }

        if (x == n - 1) {
            return 1;
        }

        vx[x] = x;
        vy[x] = y;

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += go(x + 1, i, n);
        }
        return count;
    }
}