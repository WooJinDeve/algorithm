import java.util.*;

class Solution {
    boolean solution(String s) {
        int stk = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stk++;
            else
                stk--;
            if (stk == -1)
                return false;
        }

        return stk == 0;
    }
}