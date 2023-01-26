class Solution {
    public static int solution(int n) {
        final int DIV = 1234567;
        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % DIV;
        }

        return arr[n];
    }
}