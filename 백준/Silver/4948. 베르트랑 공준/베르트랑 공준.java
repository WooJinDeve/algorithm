import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = -1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                System.out.println(sb);
                return;
            }

            boolean[] arr = new boolean[N*2+1];

            arr[0] = true;
            arr[1] = true;
            sb.append(num(arr, N, N*2)).append('\n');
        }
    }
    private static int num(boolean[] arr, int N, int N2){
        int count = 0;
        for(int i = 2; i * i <= N2; i++) {
            if(!arr[i]) {
                for(int j = i * i; j <= N2; j += i) {
                    arr[j] = true;
                }
            }
        }
        for(int i = N+1; i <= N2; i++)
            if(!arr[i]) 
                count++;
        return count;
    }
}

