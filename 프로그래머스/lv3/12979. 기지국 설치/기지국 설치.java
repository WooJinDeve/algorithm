class Solution {
   public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int m = w * 2 + 1;



        for (int i = 0; i < stations.length; i++) {
            if (i == 0) {
                answer += calculator(1, Math.max(stations[i] - w, 1), m);
            }

            if (i == stations.length - 1) {
                answer += calculator(Math.min(stations[i] + w, n), n, m);
                continue;
            }

            int start = Math.min(stations[i] + w + 1, n);
            int end = Math.max(stations[i+1] - w, 1);
            if (start >= end) {
                continue;
            }

            answer += calculator(start, end, m);
        }


        return answer;
    }

    public static int calculator(int start, int end, int m) {
        int v = end - start;
        if (v == 0) {
            return 0;
        }
        if (v > m) {
            boolean b = v % m == 0;
            return b ? v / m : v / m + 1;
        }
        return 1;
    }
}