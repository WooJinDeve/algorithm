import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long start = 0;
        long end = 0;
        int[] arr = new int[N];

        for(int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        end++;

        while (start < end){
            long total = 0;
            long mid = (start + end) / 2;
            for(int i =0; i<N; i++){
                total += arr[i] / mid;
            }
            if(total < M)
                end = mid;
            else
                start = mid + 1;

        }
        System.out.println(start - 1);
    }
}