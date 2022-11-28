class Solution {
    public int[] solution(String s) {
        int length = 0;
        int count = 0;
        while (s.length() > 1){
            length += s.length();
            s = s.replace("0", "");
            length -= s.length();
            s = Integer.toBinaryString(s.length());
            count++;
        }
        return new int[]{count, length};
    }
}