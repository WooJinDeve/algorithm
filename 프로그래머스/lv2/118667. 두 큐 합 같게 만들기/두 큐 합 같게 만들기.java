import java.util.*;
import java.util.stream.Collectors;

class Solution {
   public int solution(int[] queue1, int[] queue2){
        int ans = 0;
        List<Integer> list1 = Arrays.stream(queue1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(queue2).boxed().collect(Collectors.toList());
        Queue<Integer> queueOne = new LinkedList<>(list1);
        Queue<Integer> queueTwo = new LinkedList<>(list2);
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        int max = (list1.size() + list2.size()) * 2;

        while (sum1 != sum2) {
            if (sum1 > sum2) {
                Integer dummy = queueOne.remove();
                queueTwo.add(dummy);
                sum1 -= dummy;
                sum2 += dummy;
            }else{
                Integer dummy = queueTwo.remove();
                queueOne.add(dummy);
                sum1 += dummy;
                sum2 -= dummy;
            }
            ans++;
            if(ans > max)
                return -1;
        }
       return ans;
    }
}