import java.util.*;

class Solution {
    private static final Integer MAX = 100;
    
    public int[] solution(int[] progresses, int[] speeds) {
        int scheduleSize = progresses.length;
        List<Integer> deploy = new ArrayList<>();
        for (int i = 0; i < scheduleSize; i++) {
            int progress = progresses[i];
            int last = MAX - progress;
            int result = last % speeds[i] == 0 ? last / speeds[i] : last / speeds[i] + 1;
            int count = 1;

            for (int j = i + 1; j < scheduleSize; j++) {
                int secondProgress = progresses[j];
                int secondLast = MAX - secondProgress;
                int secondResult = secondLast % speeds[j] == 0 ? 
                        secondLast / speeds[j] : secondLast / speeds[j] + 1;
                if (result < secondResult)
                    break;
                count++;
            }
            i += count - 1;
            deploy.add(count);
        }
        return deploy.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}