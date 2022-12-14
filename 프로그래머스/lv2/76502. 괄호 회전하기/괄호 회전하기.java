import java.util.Stack;

class Solution {
     public int solution(String s){
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            String str = rotation(s, i);
            for (char ch : str.toCharArray()) {
                String suffix = String.valueOf(ch);
                if (!stack.isEmpty()){
                    if (validate(stack.peek(), suffix)){
                        stack.pop();
                        continue;
                    }
                }
                stack.add(suffix);
            }
            if (stack.isEmpty())
                result++;
            stack.clear();
        }
        return result;
    }
    
    private boolean validate(String prefix, String suffix){
        if (prefix.equals("("))
            return suffix.equals(")");
        else if (prefix.equals("{"))
            return suffix.equals("}");
        else if (prefix.equals("["))
            return suffix.equals("]");
        return false;
    }

    private String rotation(String s, int k){
        char[] rotateArray = s.toCharArray();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < s.length()-1; j++) {
                char dummy = rotateArray[j];
                rotateArray[j] = rotateArray[j+1];
                rotateArray[j+1] = dummy;
            }
        }

        return String.valueOf(rotateArray);
    }
}