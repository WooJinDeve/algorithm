import java.util.*;

class Solution {
    public long solution(String expression) {
        String[] operations = {"*+-","*-+","+-*","+*-","-*+","-+*"};
        
        expression = expression.replace("-", " - ")
                .replace("+", " + ")
                .replace("*", " * ");

        List<String> value = new LinkedList<>(Arrays.asList(expression.split(" ")));

        long ans = 0;
        for (String operation : operations) {
            List<String> dummyValue = new LinkedList<>(value);
            ans = Math.max(ans, operator(operation.split(""), dummyValue));
        }
        return ans;
    }

    private long operator(String[] operations, List<String> value) {
        for (String operation : operations) {
            for (int i = 0; i + 2 < value.size();) {
                long var1 = Long.parseLong(value.get(i));
                String oper = value.get(i + 1);
                long var2 = Long.parseLong(value.get(i + 2));
                if (oper.equals(operation)) {
                    switch (oper) {
                        case "+": value.set(i, String.valueOf(var1 + var2)); break;
                        case "-": value.set(i, String.valueOf(var1 - var2)); break;
                        case "*": value.set(i, String.valueOf(var1 * var2)); break;
                    }
                    value.remove(i + 1);
                    value.remove(i + 1);
                }else {
                    i+=2;
                }
            }
        }
        return Math.abs(Long.parseLong(value.get(0)));
    }
}