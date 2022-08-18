import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger first = in.nextBigInteger();
        BigInteger second = in.nextBigInteger();

        System.out.println(first.add(second));
        System.out.println(first.subtract(second));
        System.out.print(first.multiply(second));

    }
}