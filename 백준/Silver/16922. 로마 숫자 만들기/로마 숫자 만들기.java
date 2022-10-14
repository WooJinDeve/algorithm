import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[50*20+1];
        int n = sc.nextInt();
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n-i; j++) {
                for (int k=0; k<=n-i-j; k++) {
                    int l = n-i-j-k;
                    int sum = i+5*j+10*k+50*l;
                    check[sum] = true;
                }
            }
        }
        int ans = 0;
        for (int i=1; i<=50*20; i++) {
            if (check[i]) ans += 1;
        }
        System.out.println(ans);
    }
}
