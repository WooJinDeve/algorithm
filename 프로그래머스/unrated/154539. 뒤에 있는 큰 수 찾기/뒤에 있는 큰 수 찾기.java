import java.util.*;

class Solution {
    public static int[] solution(int[] numbers) {
        PriorityQueue<Number> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.value));
        for (int index = 0; index < numbers.length; index++) {

            final int value = numbers[index];
            
            while (!queue.isEmpty() && queue.peek().value < value){
                numbers[queue.poll().idx] = value;
            }
            queue.add(new Number(index, value));
        }
        
        while (!queue.isEmpty())
            numbers[queue.poll().idx] = -1;

        return numbers;
    }
    
    static class Number {
        private int idx;
        private int value;

        public Number(final int idx, final int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}