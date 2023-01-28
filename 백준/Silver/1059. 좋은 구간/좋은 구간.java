import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		
		int[] arr = new int[L];
		for(int i=0;i<L;i++) {
			arr[i]=sc.nextInt();
		}
		int n = sc.nextInt();
		
		Arrays.sort(arr);
		
		int answer=0;
		if(n<arr[0]) {
			answer=(arr[0]-n)*(n-1)+(arr[0]-n-1);
		}else {
			int a=0, b=0;
			for(int i=0;i<L;i++) {
				if(n==arr[i]) {
					answer=0;
					break;
				}
				if(arr[i]<n&&arr[i+1]>n) {
					a=arr[i];
					b=arr[i+1];
					answer=(b-n)*(n-a-1)+(b-n-1);
					break;
				}
			}
		}
		System.out.println(answer);
	}
}