import java.util.*;
public class Main {
    static int go(String s, int index, char last) {
        if (s.length() == index) {
            return 1;
        }
        char start = (s.charAt(index) == 'c' ? 'a' : '0');
        char end = (s.charAt(index) == 'c' ? 'z' : '9');
        int ans = 0;
        for (char i=start; i<=end; i++) {
            if (i != last) {
                ans += go(s, index+1, i);
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(go(s, 0, ' '));
    }
}
