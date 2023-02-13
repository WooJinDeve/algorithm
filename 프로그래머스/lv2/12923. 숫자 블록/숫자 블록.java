import java.util.*;

class Solution {
     public static int[] solution(long begin, long end) {
        List<Integer> answer = new ArrayList<>();

        for (long i=begin; i<=end; i++){
            if (i==1) {
                answer.add(0);
                continue;
            }
            int max=0;
            for (long j=2; j*j<=i; j++) {
                if (i%j==0) {
                    if (i/j>10000000){
                        if (j>max){
                            max = (int) j;
                        }
                    }
                    else {
                        if (i/j > max){
                            max= (int) (i/j);
                            break;
                        }
                    }
                }
            }
            if (max==0) answer.add(1);
            else answer.add(max);
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}