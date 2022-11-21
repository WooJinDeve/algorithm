class Solution {
    public int solution(String[] babbling) {
   int answer = 0;
        String[] ong = new String[]{"aya", "ye", "woo", "ma"};
        for (String s : babbling) {
            String temp = "";
            for (int i = 0; i < 4; i++) {
                String str = ong[i];
                int index = s.indexOf(str);
                if(index == 0 && !temp.equals(str)){
                    temp = str;
                    s = s.replaceFirst(str, "");
                    i = -1;
                }
            }
            if (s.length() == 0){
                answer++;
            }
        }

        return answer;
    }
}