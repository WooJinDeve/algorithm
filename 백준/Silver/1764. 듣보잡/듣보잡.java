import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, String> hashMap = new HashMap<>();
        for(int i = 0; i<n; i++) {
            String str = sc.next();
            hashMap.put(str, str);
        }

        List<String> list = new ArrayList<>();
        for(int i = 0; i<m; i++){
            String str = sc.next();
            if(hashMap.containsKey(str))
                list.add(str);
        }

        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(int i = 0; i<list.size(); i++)
            sb.append(list.get(i)).append('\n');

        System.out.println(sb);
    }

}