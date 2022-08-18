import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0 ; i < N ; i++) {
            String a = sc.next();
            int l = a.length();
            String f_c = String.valueOf(a.charAt(0));
            String l_c = String.valueOf(a.charAt(l-1));
            System.out.println(f_c+l_c);
        }
    }
}