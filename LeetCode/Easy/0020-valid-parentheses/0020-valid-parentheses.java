import java.util.Stack;

class Solution {
    public boolean isValid(final String s) {
        final Stack<String> parentheses = new Stack<>();

        for(String bracket : s.split("")){
            if(bracket.equals("(") || bracket.equals("{") || bracket.equals("[")){
                parentheses.add(bracket);
                continue;
            }
            if (hasDeletable(bracket, parentheses)) {
                parentheses.pop();
                continue;
            }
            return false;
        }

        return parentheses.isEmpty();
    }

    private boolean hasDeletable(final String bracket, final Stack<String> parentheses) {
        switch (bracket) {
            case ")": return !parentheses.isEmpty() && parentheses.peek().equals("(");
            case "}": return !parentheses.isEmpty() && parentheses.peek().equals("{");
            case "]": return !parentheses.isEmpty() && parentheses.peek().equals("[");
            default: return true;
        }
    }
}