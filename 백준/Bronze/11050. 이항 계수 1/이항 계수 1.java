import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(num(sc.nextInt(),sc.nextInt()));
    }

    public static int num(int n, int k){
        if(k == 0 || n == k)
            return 1;
        return num(n-1,k)+num(n-1, k-1);
    }
}