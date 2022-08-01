import java.util.*;


public class Main{
    public static void main(String[] args){
        int num = new Scanner(System.in).nextInt();
        int count =0;
        for(int i = 1; i<=num; i++) {
            if (i < 100)
                count++;
            else if (i / 100 % 10 - i / 10 % 10 == i / 10 % 10 - i % 10)
                count++;
        }
        System.out.println(num==1000?--count:count);
    }
}