import java.util.*;
 
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
         PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String table : timetable) {
            int time = Integer.parseInt(table.substring(0, 2)) * 60 + Integer.parseInt(table.substring(3));
            pq.add(time);
        }

        int answer = 0;
        int start = 9 * 60;
        int last = start + (n-1) * t;
        
        for(int i = 0; i < n; i++) {
            int count = 0;
            while(!pq.isEmpty()) {
                int current = pq.peek();
                if(current <= start + i * t && count < m) {
                    pq.poll();
                    count++;
                } else break;

                answer = current - 1;
            }
            
            if(count < m)
                answer = last;
        }

        return String.format("%02d", answer / 60) + ":" + String.format("%02d", answer % 60);
    }
}
