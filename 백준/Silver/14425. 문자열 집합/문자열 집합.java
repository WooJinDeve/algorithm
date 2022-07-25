import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i<n; i++)
            hashMap.put(sc.next(),1);

        int count = 0;
        for(int i = 0; i<m; i++){
            if(hashMap.containsKey(sc.next()))
                count++;
        }

        System.out.println(count);
    }

}