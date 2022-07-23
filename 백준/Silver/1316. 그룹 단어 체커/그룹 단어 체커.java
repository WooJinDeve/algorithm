import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count=0;
        for(int i = sc.nextInt(); i>0; i--) {
            String str = sc.next();
            HashSet set = new HashSet();
            int j;
            for (j = 0; j < str.length(); j++) {
                int size = set.size();
                set.add(str.charAt(j));
                if(set.size() == size +1 || str.charAt(j - 1) == str.charAt(j));
                else
                    break;
            }if(j == str.length())
                count++;
        }
        System.out.println(count);
    }
}