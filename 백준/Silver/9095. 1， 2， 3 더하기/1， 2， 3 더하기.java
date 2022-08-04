import java.util.*;
public class Main {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[12];
        arr[1] = 1;  // 1
        arr[2] = 2;  // 1+1 / 2
        arr[3] = 4;
        arr[4] = 7;
        arr[5] = 13;
        for(int j = 4; j<=10; j++){
            arr[j] = arr[j-3] + arr[j-2] + arr[j-1];
        }
        while (T-->0){
            System.out.println(arr[sc.nextInt()]);
        }
    }
}