import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		if (a.length() >= b.length()) {
			System.out.println("go");
		}else {
			System.out.println("no");
		}
	}
}