import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            Meeting meeting = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            meetings.add(meeting);
        }

        meetings.sort(Comparator.comparing(Meeting::getEnd).thenComparing(Meeting::getStart));

        int count = 0;
        int endtime = 0;
        for(int i = 0; i < N; i++) {
            if(endtime <= meetings.get(i).start) {
                endtime = meetings.get(i).end;
                count++;
            }
        }
        System.out.println(count);
    }

    public static class Meeting{
        private int start;
        private int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        public int getStart() {
            return start;
        }
    }
}