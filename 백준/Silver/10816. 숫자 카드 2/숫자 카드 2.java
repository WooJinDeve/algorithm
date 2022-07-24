import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int dummy = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(dummy)){
                int count = hashMap.get(dummy) + 1 ;
                hashMap.put(dummy,count);
            }else
                hashMap.put(dummy,1);
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            int dummy = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(dummy))
                sb.append(hashMap.get(dummy)).append(" ");
            else
                sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}