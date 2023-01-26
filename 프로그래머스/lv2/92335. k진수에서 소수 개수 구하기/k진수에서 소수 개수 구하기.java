class Solution {
    public int solution(int n, int k) {
        int ans = 0;
        String s = Integer.toString(n, k);
        for(String prime : s.split("0")){
            if (prime.isEmpty())
                continue;
            if (verifyPrime(Long.parseLong(prime)))
                ans++;
        }
        return ans;
    }

    private boolean verifyPrime(long num){
        if (num == 1) 
            return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}