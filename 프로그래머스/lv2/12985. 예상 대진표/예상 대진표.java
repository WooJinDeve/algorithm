class Solution
{
    public int solution(int n, int a, int b)
    {
        int ans = 1;
        while (Math.abs(a - b) != 1 || a / 2 == b / 2){
            ans++;
            a = (a % 2 == 1) ? a / 2 + 1 : a / 2;
            b = (b % 2 == 1) ? b / 2 + 1 : b / 2;
        }
        return ans;
    }
}