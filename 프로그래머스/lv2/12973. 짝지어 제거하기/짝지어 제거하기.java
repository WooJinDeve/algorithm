import java.util.Objects;
import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Integer> stk = new Stack<>();
        for (char ch : s.toCharArray()) {
            stk.add((int) ch);
            while (stk.size() >= 2) {
                Integer ch1 = stk.pop();
                Integer ch2 = stk.pop();
                if (!Objects.equals(ch1, ch2)){
                    stk.add(ch2);
                    stk.add(ch1);
                    break;
                }
            }
        }
        return stk.isEmpty() ? 1 : 0;
    }
}