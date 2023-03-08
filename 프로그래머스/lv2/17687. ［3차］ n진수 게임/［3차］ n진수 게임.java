class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb=new StringBuilder();
        StringBuilder answer=new StringBuilder();
        for (int i = 0; i < m*t; i++) {
            sb.append(Integer.toString(i,n));
        }
        for (int i = p-1; i < m*t; i+=m) {
            answer.append(sb.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}