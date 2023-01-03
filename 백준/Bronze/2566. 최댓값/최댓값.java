import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		int nums[][] = new int[10][10];
		int max = 0;
		int x = 0, y = 0;

		for (int i = 0; i < 9; i++) 
		{
			for (int j = 0; j < 9; j++) 
			{
				nums[i][j] = sc.nextInt();
				if (max < nums[i][j]) 
				{
					max = nums[i][j];
					x = i; y = j;
				}
			}
		}

		System.out.println(max);
		System.out.println((x + 1) + " " + (y + 1));
	}
}