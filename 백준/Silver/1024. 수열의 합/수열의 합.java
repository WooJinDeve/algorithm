import java.util.*;
import java.lang.*;
import java.io.*;
 
class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] sArr = br.readLine().split(" ");
        long N = Long.valueOf(sArr[0]);
        long L = Long.valueOf(sArr[1]);
        boolean flag = true;
        
        for(long i = L; i <= 100 && flag; i++){
            long sum = (i * (i - 1)) / 2;
            long idx = 0;
            
            while(true){
                if(sum == N){
                    for(long k = 0; k < i; k++)
                        bw.write(idx + k + " ");
                        
                    flag = false;
                    break;
                }
                
                sum += i;
                idx += 1;
                
                if(sum > N)
                    break;
            }
        }
        
        if(flag)
            bw.write("-1");
            
        bw.write("\n");
        bw.flush();
    }
}
