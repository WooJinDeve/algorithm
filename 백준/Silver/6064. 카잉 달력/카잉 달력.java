import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());
        while (t-- > 0) {
            String[] line = bf.readLine().split(" ");
            int m = Integer.valueOf(line[0]);
            int n = Integer.valueOf(line[1]);
            //0 <= value <m*n
            int x = Integer.valueOf(line[2])-1;
            int y = Integer.valueOf(line[3])-1;
            int value = -1;
            for (int k=x; k<(n*m); k+=m) {
                if (k%n == y) {
                    value = k+1;
                    break;
                }
            }
            System.out.println(value);
        }
    }
}