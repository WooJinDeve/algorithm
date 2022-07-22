import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            boolean bool = false;
            if(a == 0 && b == 0 && c == 0)
                break;

            if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2))
                bool = true;
            else if(Math.pow(a,2) + Math.pow(c,2) == Math.pow(b,2))
                bool = true;
            else if(Math.pow(b,2) + Math.pow(c,2) == Math.pow(a,2))
                bool = true;

            sb.append(bool == true ? "right": "wrong").append('\n');
        }
        System.out.println(sb);
    }
}