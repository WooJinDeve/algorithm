import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("0")){
                System.out.println(sb);
                return;
            }
            boolean check = true;
            for(int i = 0; i<str.length()/2; i++){
                if(str.charAt(i) != str.charAt(str.length()-1-i)){
                    check = false;
                    break;
                }
            }
            if(check)
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');
        }
    }
}