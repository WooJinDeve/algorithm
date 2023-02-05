import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				if(!queue.isEmpty())
					System.out.println(queue.poll());
				else
					System.out.println(0);
				continue;
			}
			queue.add(num);
		}
	}
}