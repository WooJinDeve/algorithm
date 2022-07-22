import java.math.BigInteger;
import java.util.*;

public class Main{
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        BigInteger res = new BigInteger("1");
        int N = scan.nextInt();
        if (N<=20) {
            hanoi(N, '1', '2', '3');
            sb.insert(0, (int)(Math.pow(2, N) - 1) + "\n");
            System.out.print(sb);
        } else {
            for(int i=0; i<N; ++i) {
                res = res.multiply(new BigInteger("2")); // 2의 N 제곱
            }
            res = res.subtract(new BigInteger("1")); // 빼기 1
            System.out.println(res);
        }
    }
    private static void hanoi(int n, char A, char B, char C){
        count++;
        if(n==1){
            sb.append(A + " " +C).append('\n');
        }else{
            hanoi(n-1,A,C,B);
            sb.append(A + " " + C).append('\n');
            hanoi(n-1,B,A,C);
        }
    }

}