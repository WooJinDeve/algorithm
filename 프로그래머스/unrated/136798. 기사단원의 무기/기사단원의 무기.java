class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int size = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) size++;
                else if (i % j == 0) size += 2;
            }
            if(limit < size){
                size = power;
            }
            answer += size;
        }
        return answer;
    }
}