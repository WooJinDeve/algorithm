import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        System.out.println(Math.min(Math.min(0+x,w-x),Math.min(0+y,h-y)));
    }
}