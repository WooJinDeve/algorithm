import java.util.*;

public class Main{
    public static void main(String[] args){
        for(int i = new Scanner(System.in).nextInt(), j = 1; i>0; i--){
            System.out.println(" ".repeat(i-1) + "*".repeat(j++));
        }
    }
}