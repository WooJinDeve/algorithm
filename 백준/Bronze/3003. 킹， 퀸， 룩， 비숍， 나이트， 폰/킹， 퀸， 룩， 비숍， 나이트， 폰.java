import java.io.IOException;
import java.util.Scanner;

 public class Main {
     public static void main(String[] args) throws IOException {
         Scanner scanner = new Scanner(System.in);
         int[] cnt = new int[6];
         int[] full = new int[]{1, 1, 2, 2, 2, 8};
         for (int i = 0; i < 6; i++) {
             cnt[i] = scanner.nextInt();
         }

         for (int i = 0; i < full.length; i++) {
             cnt[i] = full[i] - cnt[i];
             System.out.println(cnt[i]);
         }
     }
 }