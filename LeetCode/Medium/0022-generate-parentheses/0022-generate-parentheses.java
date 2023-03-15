import java.util.*;

class Solution {
    private List<String> answer;

    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        recursionParenthesis("", 0, n * 2);
        return answer;
    }

    private void recursionParenthesis(String parenthesis, int depth, int max){
        if (depth == max) {
            if (validateParenthesis(parenthesis))
                answer.add(parenthesis);
            return;
        }
        recursionParenthesis(parenthesis + "(", depth + 1, max);
        recursionParenthesis(parenthesis + ")", depth + 1, max);
    }

    private boolean validateParenthesis(String parenthesis){
        int n = 0;
        for (String s : parenthesis.split("")) {
            if (s.equals("(")) n++;
            else if(s.equals(")")) n--;

            if (n < 0) return false;
        }
        return n == 0;
    }
}