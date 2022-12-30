import java.util.*;
public class Main {
    static String zfill(String s, int cnt) {
        while (s.length() < cnt) {
            s = "0" + s;
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ipv6 = sc.next();
        // 2001:db8:85a3::8a2e:370:7334
        // 25:09:1985:aa:091:4846:374:bb
        // ::1
        ArrayList<String> parts = new ArrayList<>(Arrays.asList(ipv6.split(":", -1)));
        // ipv6 = "1::"인 경우
        // ipv6.split(":") = ["1"]
        // ipv6.split(":", -1) = ["1", "", ""]
        
        // parts = ["2001", "db8", "85a3", "", "8a2e", "370", "7334"]
        // parts = ["25", "09", "1985", "aa", "091", "4846", "374", "bb"]
        // parts = ["", "", "1"]

        if (Collections.frequency(parts, "") > 1) { // ::1, 1::
            // parts = ["", "", "1"]
            parts.remove("");
            // parts = ["", "1"]
        }
        if (parts.size() < 8) {
            // parts = ["2001", "db8", "85a3", "", "8a2e", "370", "7334"]
            // parts = ["", "1"]
            int index = parts.indexOf("");
            // parts = ["2001", "db8", "85a3", "", "8a2e", "370", "7334"]
            //                                 index
            // parts = ["", "1"]
            //          index
            parts.remove(index);
            // parts = ["2001", "db8", "85a3", "8a2e", "370", "7334"]
            //                                 index
            // parts = ["1"]
            //          index
            int cnt = 8 - parts.size();
            for (int i=0; i<cnt; i++) {
                parts.add(index, "0");
            }
            // parts = ["2001", "db8", "85a3", "0", "0", "8a2e", "370", "7334"]
            //                                 index
            // parts = ["0", "0", "0", "0", "0", "0", "0", 1"]
            //          index
        }
        for (int i=0; i<parts.size(); i++) {
            System.out.print(zfill(parts.get(i), 4));
            if (i+1 < parts.size()) {
                System.out.print(":");
            }
        }
        System.out.println();
    }
}