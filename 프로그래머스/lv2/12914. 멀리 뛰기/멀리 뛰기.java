class Solution {
    private static final int DIV = 1234567;
    
    public long solution(int n) {
        int[] arr = new int[2001];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + arr[i - 2]) % DIV;
        }

        return arr[n];
    }
}