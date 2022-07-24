import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();	 
		for(int i = 0; i < T; i++) {
			
			int H = in.nextInt();
			int W = in.nextInt(); 	
			int N = in.nextInt();
			
			if(N % H == 0) {
				System.out.println((H * 100) + (N / H));
 
			} else {
				System.out.println(((N % H) * 100) + ((N / H) + 1));
			}
		}
	}
}