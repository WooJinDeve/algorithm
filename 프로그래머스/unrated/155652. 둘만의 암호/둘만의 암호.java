class Solution {
    public String solution(String s, String skip, int index) {
        char[] answer = s.toCharArray();
        for(int i = 0 ; i < answer.length ; i++){
            for(int j = 0 ; j < index ; j++){
                do{
                    answer[i]++;
                    if(answer[i] > 'z'){
                        answer[i] -= 26;
                    }
                }while(skip.contains(String.valueOf(answer[i])));
            }
        }
        return String.valueOf(answer);
    }
}