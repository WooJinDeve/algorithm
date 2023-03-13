import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        int[] wood = new int[N];
        for(int i = 0; i<N; i++) {
            wood[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, wood[i]);
        }

        while (start < end){
            long total = 0;
            int mid = (start + end) / 2;
            for(int i =0; i<N; i++){
                if(wood[i] - mid > 0)
                    total += wood[i] - mid;
            }
            if(total < M)
                end = mid;
            else
                start = mid + 1;

        }
        System.out.println(start -1);
    }
}