class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        for (int i = 0; i < t.length(); i++) {
            if (i + size <= t.length() && t.substring(i, i + size).compareTo(p) <= 0){
                answer++;
            }
        }
        return answer;
    }
}