import java.util.*;

class Solution {
    public String solution(String p) {
        if (isBalance(p))
            return p;
        return recursion(p);
    }
    
    public String recursion(String p){
        if (p.length() == 0)
            return "";

        int idx = isCountPair(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);

        if (isBalance(u)){
            u += recursion(v);
            return u;
        }else {
            String newP = "(" +  recursion(v) + ")";
            newP += reverse(u);
            return newP;
        }
    }
    
    public int isCountPair(String str){
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            counter = str.charAt(i) == '(' ? counter+1 : counter -1;
            if (counter == 0)
                return i + 1;
        }
        return 0;
    }
    
    public boolean isBalance(String p){
        Stack<String> stack = new Stack<>();
        for (char ch : p.toCharArray()) {
            if (stack.isEmpty() && ch == ')')
                return false;
            if (ch == '(') stack.add(ch + "");
            else stack.pop();
        }
        return true;
    }
    
    public String reverse(String u){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(')
                sb.append(')');
            else
                sb.append('(');
        }
        return sb.toString();
    }
}