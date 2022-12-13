class Solution {
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        recursion(0, 0, numbers, target);
        return count;
    }
    
    private void recursion(int depth, int sum, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target)
                count++;
            return;
        }
        recursion(depth + 1, sum + numbers[depth], numbers, target);
        recursion(depth + 1, sum - numbers[depth], numbers, target);
    }
}