import java.util.Scanner;
import java.lang.Math;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt();
        int C = sc.nextInt(), D = sc.nextInt();
        System.out.println(Math.abs((A+D) - (B+C)));
    }
}