import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static String[] solution(String[][] plans) {
        PriorityQueue<Class> queue = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1.start));
        Arrays.stream(plans).forEach(plan -> queue.add(new Class(plan[0], plan[1], plan[2])));

        Stack<Class> stk = new Stack<>();
        List<String> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            Class e = queue.remove();
            if (queue.isEmpty()) {
                answer.add(e.name);
                continue;
            }

            int time = 0;
            if (queue.peek().start >= e.start + e.time){
                time = queue.peek().start - (e.start + e.time);
                answer.add(e.name);
            }else {
                e.time = (e.start + e.time) - queue.peek().start;
                stk.add(e);
                continue;
            }

            while (time != 0 && !stk.isEmpty()){
                Class el = stk.pop();
                if (el.time <= time){
                    time -= el.time;
                    answer.add(el.name);
                }else {
                    el.time -= time;
                    stk.add(el);
                    break;
                }
            }
        }

        while (!stk.isEmpty()){
            answer.add(stk.pop().name);
        }

        return answer.stream()
                .toArray(String[]::new);
    }

    static class Class {
        private String name;
        private int start;
        private int time;

        public Class(String name, String start, String time) {
            this.name = name;
            this.start = convertTimeToInt(start);
            this.time = convertStringToInt(time);
        }

        private int convertTimeToInt(String time) {
            return convertStringToInt(time.split(":")[0]) * 60
                    + convertStringToInt(time.split(":")[1]);
        }

        private int convertStringToInt(String str) {
            return Integer.parseInt(str);
        }
    }
}