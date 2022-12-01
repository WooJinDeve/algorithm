class Solution {
    public int solution(int n) {
        int nLength = Integer.toBinaryString(n)
                .replace("0", "").length();
        
        while (true){
            String nextInt = Integer.toBinaryString(++n);
            int nextIntLength = nextInt.replace("0", "").length();
            if (nLength == nextIntLength)
                return n;
        }
    }
}