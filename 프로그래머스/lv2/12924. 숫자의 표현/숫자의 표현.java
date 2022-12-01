class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = i; j <= n; j++) {
                temp += j;
                if(n - temp == 0)
                    answer++;
                else if(n - temp < 0)
                    break;
            }
        }
        return answer;
    }
}