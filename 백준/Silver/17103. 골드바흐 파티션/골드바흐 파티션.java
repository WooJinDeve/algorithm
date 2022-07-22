import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            boolean[] Prime = goldbach(new boolean[N+1]);
            int count = 0;
            for(int i = 2; i <= N/2; i++) {
                if(!Prime[i] && !Prime[N-i])
                   count++;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    public static boolean[] goldbach(boolean[] Prime){
        Prime[0] = true;
        Prime[1] = true;
        for(int i = 2; i<=Math.sqrt(Prime.length); i++){
            if (Prime[i])
                continue;
            for(int j = i*i; j<Prime.length; j+=i){
                Prime[j] = true;
            }
        }
        return Prime;
    }
}
