import java.math.*;

class Solution {
    public long solution(int w, int h) {
        long gdc = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * h) - (((w / gdc) + (h / gdc) - 1) * gdc);
    }
}