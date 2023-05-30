class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        int middleNumber = total / num;
        int subtracNumber = total % num == 0 ? num / 2 : num / 2 - 1;

        int startNumber = middleNumber - subtracNumber;

        for (int i = 0; i < num; i++) {
            answer[i]= startNumber + i; 
        }
        return answer;
    }
}