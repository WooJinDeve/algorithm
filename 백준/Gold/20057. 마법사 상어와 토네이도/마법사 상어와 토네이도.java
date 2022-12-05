import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0,1,0,-1};   //토네이토의 x 이동 방향
    static int[] dy = {-1,0,1,0};   //토네이토의 y 이동 방향
    static int[] dc = {1,1,2,2};   // 토네이도의 각 방향으로 이동하는 횟수
    static int[][] dsx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
                          {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
                          {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] sandRatio ={1,1,2,7,7,2,10,10,5};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine()," ");
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = calculateOutSand(N/2, N/2);
        bw.write(String.valueOf(result));
        bw.flush();




    }
    //현재위치에서 이동 -> 이동한 위치의 모래 뿌리기 -> 이동한위치를 현재위치로 업데이트
    static int calculateOutSand(int x, int y){
        int totalOutSand = 0;

        int currentX = x;
        int currentY = y;

        while (true) {
            for(int d = 0; d<4; d++){
                for(int moveCount = 0; moveCount<dc[d]; moveCount++){
                    //현재위치에서 이동
                    int nextX = currentX+dx[d];
                    int nextY = currentY+dy[d];

                    if(nextX<0 || nextY<0 || nextX>=N ||nextY>=N){
                        return totalOutSand;
                    }

                    //이동한 위치의 모래 뿌리기
                    int sand = map[nextX][nextY];
                    map[nextX][nextY] = 0;
                    int spreadTotal = 0;


                    for(int spread = 0; spread<9; spread++){
                        int sandX = nextX + dsx[d][spread];
                        int sandY = nextY + dsy[d][spread];
                        int spreadAmount = (sand*sandRatio[spread])/100;

                        if(sandX<0 || sandX>=N || sandY<0 || sandY>=N){
                            totalOutSand += spreadAmount;
                        }
                        else{
                            map[sandX][sandY]+=spreadAmount;
                        }
                        spreadTotal+= spreadAmount;
                    }

                    //알파
                    int alphaX = nextX+dx[d];
                    int alphaY = nextY+dy[d];
                    int alphaAmount = sand -spreadTotal;
                    if(alphaX<0 || alphaX>=N || alphaY<0|| alphaY>=N){
                        totalOutSand +=alphaAmount;
                    }
                    else{
                        map[alphaX][alphaY] +=alphaAmount;
                    }


                    //이동한 위치를 현재위치로 업데이트
                    currentX = nextX;
                    currentY = nextY;
                }
            }

            //횟수 업데이트
            for(int index = 0; index<4; index++){
                dc[index] +=2;
            }
        }
    }

}