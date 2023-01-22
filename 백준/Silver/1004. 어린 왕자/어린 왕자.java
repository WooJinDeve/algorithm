import java.io.*;
import java.util.StringTokenizer;

class Planet{
    int x;
    int y;
    int radius;

    public Planet(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int answer = 0;

            // 입력 값 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            Planet arr[] = new Planet[n];

            // 행성 정보 초기화
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());

                // 출발점이 현재 행성의 안에 있는지 밖에 있는지 여부
                boolean check1 = false;
                // 도착점이 현재 행성의 안에 있는지 밖에 있는지 여부
                boolean check2 = false;

                // 시작점이 행성의 밖에 있으면 true
                if(Math.pow(startX - x, 2) + Math.pow(startY - y, 2) > Math.pow(radius, 2)) check1 = true;
                // 도착점이 행성의 밖에 있으면 true
                if(Math.pow(endX - x, 2) + Math.pow(endY - y, 2) > Math.pow(radius, 2)) check2 = true;

                // 시작점, 도착점 둘 중에 하나만 행성안에 있고 다른점은 밖에 있는 경우
                if(check1 == true && check2 == false) answer++;
                else if(check1 == false && check2 == true) answer++;
            }

            bw.write(answer + "\n");
        }
        bw.close();
        br.close();
    }
}