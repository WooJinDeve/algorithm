import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String S = sc.next();
        BigInteger result = new BigInteger("0");

        for(int i = 0; i<n;i++){
            result = result.add(BigInteger.valueOf(S.charAt(i) - 96).multiply(BigInteger.valueOf(31).pow(i)));
        }

        System.out.println(result.remainder(BigInteger.valueOf(1234567891)));
    }
}