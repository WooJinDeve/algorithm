import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        Integer arr[]=new Integer[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr,Collections.reverseOrder());
        System.out.println(arr[k-1]);
    }
}
