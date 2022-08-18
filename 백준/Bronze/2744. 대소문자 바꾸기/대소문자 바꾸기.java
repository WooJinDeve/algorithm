import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		char[] arr;
		arr = input.toCharArray();
		for (int i = 0; i < arr.length; ++i) {
			if (65 <= arr[i] && arr[i] <= 90) {
				arr[i] = (char) (arr[i] + 32);
				continue;
			}
			if (97 <= arr[i] && arr[i] <= 122) {
				arr[i] = (char) (arr[i] - 32);
				continue;
			}
		}

		System.out.print(arr);
	}
}