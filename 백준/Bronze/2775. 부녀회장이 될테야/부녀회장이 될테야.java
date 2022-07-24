import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[][] arr = new int[15][15];
 
		for(int i = 0; i < 15; i++) {
			arr[i][1] = 1;	
			arr[0][i] = i;	
		}
 
		for(int i = 1; i < 15; i ++) {	
			for(int j = 2; j < 15; j++) {
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
			}
		}
		 		
		int T = in.nextInt();
		for(int i = 0; i < T; i++) {
			int k = in.nextInt();
			int n = in.nextInt();
			System.out.println(arr[k][n]);
		}
	}
 
}