import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int start_index = 0;
            int end_index = i + 1;
            while (end_index <= s.length()) {
                set.add(s.substring(start_index, end_index));
                start_index++;
                end_index++;
            }
        }

        System.out.println(set.size());
    }
}