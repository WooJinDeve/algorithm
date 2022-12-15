class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        
        for(int i = 0; i < length; i++){
            int count = -1; 
            int value = prices[i];
            for(int j = i; j < length; j++){
                if(value > prices[j]){
                    count = j - i;
                    break;
                }
            }
            answer[i] = count == -1 ? length - i - 1 : count;
        }
        return answer;
    }
}