class Solution {
    public int reverse(int x) {
        long answer = 0L;
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        while (x > 0){
            int lastInt = x % 10;
            answer = answer * 10 + lastInt;
            if (sign * answer < Integer.MIN_VALUE) return 0;
            if (sign * answer > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        return sign * (int)answer;
    }
}