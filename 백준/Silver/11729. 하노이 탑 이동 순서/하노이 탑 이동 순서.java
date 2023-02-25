import java.util.*;

public class Main{
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        int n = new Scanner(System.in).nextInt();

        hanoi(n,'1','2','3');

        System.out.println(count);
        System.out.println(sb);
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