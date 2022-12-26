import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        ArrayList<String> d = new ArrayList<>();
        d.add("()");
        for (int len=4; len<=s.length(); len+=2) {
            for (int i=0; i<d.size(); i++) {
                String cur = d.get(i);
                if ((len-2) % cur.length() == 0) {
                    StringBuilder next = new StringBuilder();
                    next.append("(");
                    for (int j=0; j<(len-2)/cur.length(); j++) {
                        next.append(cur);
                    }
                    next.append(")");
                    d.add(next.toString());
                }
            }
        }
        Collections.sort(d);
        for (String x : d) {
            int index = 0;
            for (int i=0; index<x.length() && i<s.length(); i++) {
                if (x.charAt(index) == s.charAt(i)) {
                    index += 1;
                }
            }
            if (index == x.length()) {
                k -= 1;
                if (k == 0) {
                    System.out.println(x);
                    System.exit(0);
                }
            }
        }
        System.out.println("-1");
    }
}