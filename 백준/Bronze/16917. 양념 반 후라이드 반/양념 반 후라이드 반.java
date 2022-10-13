import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int ans = x*a+y*b;
        for (int i=1; i<=100000; i++) {
            int price = 2*i*c + Math.max(0, x-i)*a + Math.max(0, y-i)*b;
            if (ans > price) ans = price;
        }
        System.out.println(ans);
    }
}
