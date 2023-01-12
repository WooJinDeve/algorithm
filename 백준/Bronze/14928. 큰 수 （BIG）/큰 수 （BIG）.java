import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
    	Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        long temp = 0;
        for (int i = 0; i < input.length(); i++) {
        	temp = (temp * 10 + (input.charAt(i) - '0')) % 20000303;
        }
        
        System.out.println(temp);
    }
}