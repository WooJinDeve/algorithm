import java.util.*;
public class Main {
    static int N = 0;
    static int[] vy = new int[16];
    static int[] vx = new int[16];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int r = 0;
        for(int i = 0; i<N; i++)
            r += go(0,i);

        System.out.println(r);
    }
    public static int go(int y, int x){
        for(int i = 0; i<y; i++){
            if(y==vy[i]) return  0;
            if(x==vx[i]) return  0; //
            if(Math.abs(x-vx[i]) == Math.abs(y-vy[i])) return  0; // 대각선
        }

        if(y == N - 1){
            return 1;
        }
        vy[y] = y;
        vx[y] = x;

        int r = 0;
        for (int i = 0; i<N; i++){
            r+= go(y+1,i);
        }
        return r;

    }

}