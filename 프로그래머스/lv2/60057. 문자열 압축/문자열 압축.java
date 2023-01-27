class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length()/2; i++) {
            int level = 1;
            String compare = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j = i; j <= s.length(); j += i) {
                String next = s.substring(j, Math.min(j + i, s.length()));
                if (compare.equals(next)) {
                    level++;
                    continue;
                }

                String text = (level == 1 ? "" : level) + compare;
                sb.append(text);
                compare = next;
                level = 1;
            }
            sb.append(compare);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}