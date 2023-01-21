import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = br.readLine().split(" ");

        final BigInteger lhs = new BigInteger(input[0]);
        final BigInteger rhs = new BigInteger(input[1]);

        System.out.print(lhs.multiply(rhs));
    }
}