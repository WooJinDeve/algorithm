import java.io.*;

public class Main{
    static boolean[] Prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        goldbach();
        while(true) {
            int N = Integer.parseInt(br.readLine());
            boolean ok = false;
            if(N == 0)
                break;
            for(int i = 2; i <= N/2; i++) {
                if(!Prime[i] && !Prime[N-i]) {
                    sb.append(N  + " = " + i + " + " + (N-i)).append('\n');
                    ok = true;
                    break;
                }
            }
            if(!ok)
                sb.append("Goldbach's conjecture is wrong.").append('\n');
        }
        System.out.println(sb);
    }

    public static void goldbach(){
        Prime[0] = true;
        Prime[1] = true;
        for(int i = 2; i<=Math.sqrt(Prime.length); i++){
            if (Prime[i])
                continue;
            for(int j = i*i; j<Prime.length; j+=i){
                Prime[j] = true;
            }
        }
    }
}
