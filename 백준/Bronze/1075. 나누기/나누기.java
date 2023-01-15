import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

  
        int N = sc.nextInt();
        int F = sc.nextInt();

        int num_2 = N % 100;
        int num_b = N - num_2; 

        while((num_b % F) != 0){ 
            num_b++; 
        }

        int re = num_b % 100;

        if(re > 9){
            System.out.println(re); 
        }else{ 
            System.out.print('0');
            System.out.println(re);
        }

        sc.close();
    }
}