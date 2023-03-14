class Solution {
    public boolean isPalindrome(int num) {
        if(num < 0) return  false;
        int reversed = 0, remainder, original = num;
        while(num != 0) {
            remainder = num % 10;
            reversed = reversed * 10 + remainder; 
            num  /= 10;
        }

        return original == reversed;
    }
}