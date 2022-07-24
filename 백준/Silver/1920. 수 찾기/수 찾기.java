import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String > set = new HashSet<>();

        while (st.hasMoreTokens()){
            set.add(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int size = set.size();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            set.add(st.nextToken());
            if(size == set.size())
                sb.append(1).append('\n');
            else{
                sb.append(0).append('\n');
                size = set.size();
            }
        }
        System.out.println(sb);
    }

}