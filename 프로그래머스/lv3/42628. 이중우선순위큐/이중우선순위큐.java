import java.util.*;

class Solution {
   public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> main = new PriorityQueue<>();
        Deque<Integer> sub = new ArrayDeque<>();

        for (String operation : operations) {
            switch (operation){
                case "D -1":
                    main.poll();
                    break;
                case "D 1":
                    shift(main, sub);
                    sub.pollLast();
                    reverseShift(main, sub);
                    break;
                default:
                    main.add(Integer.parseInt(operation.substring(2)));
            }
        }


        if (!main.isEmpty()){
            shift(main, sub);
            answer[0] = sub.isEmpty() ? 0 : sub.pollLast();
            answer[1] = sub.isEmpty() ? 0 : sub.poll();
        }

        return answer;
    }

    public void shift(Queue<Integer> main, Deque<Integer> sub){
        if (main.isEmpty()) {
            return;
        }

        while (!main.isEmpty()) {
            sub.add(main.poll());
        }
    }

    public void reverseShift(Queue<Integer> main, Deque<Integer> sub){
        if (sub.isEmpty()) {
            return;
        }

        while (!sub.isEmpty()) {
            main.add(sub.pollLast());
        }
    }
}