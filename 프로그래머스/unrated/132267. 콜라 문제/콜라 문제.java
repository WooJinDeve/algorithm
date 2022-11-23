class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int cola = 0;
        do {
            cola = (n / a) * b;
            n = n % a + cola;
            answer += cola;

        } while (cola != 0);
        return answer;
    }
}