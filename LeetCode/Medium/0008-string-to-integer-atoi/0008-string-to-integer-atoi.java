class Solution {
    public int myAtoi(String s) {
        s = s.strip();
        if (s.equals("")) return 0;

        int sign = s.charAt(0) == '-' ? -1 : 1;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);

        long sum = 0L;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) break;

            sum = sum * 10 + (c - '0');
            if (sign * sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;;
            if (sign * sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }

        return sign * (int)sum;
    }
}