import java.io.*;
 
public class Main {
 
	static int zero;
	static int one;
	static int zero_plus_one;
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);			
			sb.append(zero).append(' ').append(one).append('\n');
		}
		System.out.println(sb);
 
	}
 
	public static void fibonacci(int N) {
		zero = 1;
		one = 0;
		zero_plus_one = 1;
 
		for (int i = 0; i < N; i++) {
			zero = one;
			one = zero_plus_one;
			zero_plus_one = zero + one;
		}
 
	}
 
}