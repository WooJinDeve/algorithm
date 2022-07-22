import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] bool = new boolean[sc.nextInt()+1];
        bool[0] = bool[1]=true;

        System.out.println(prime(bool, sc.nextInt()));
    }
    public static int prime(boolean[] bool, int n){
        int count = 0;
        for(int i = 2; i<=bool.length; i++){
            if(bool[i])
                continue;
            if(++count == n)
                return i;
            for(int j = i*i; j<bool.length; j += i){
                if(bool[j])
                    continue;
                bool[j] = true;
                if(++count == n)
                   return j;
            }
        }
        return 0;
    }
}
