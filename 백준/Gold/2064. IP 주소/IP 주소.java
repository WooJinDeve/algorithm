import java.util.*;
public class Main {
    static String zfill(String s, int cnt) {
        while (s.length() < cnt) {
            s = "0" + s;
        }
        return s;
    }
    static String dec_to_bin(int x) {
        String ans = "";
        while (x > 0) {
            ans += (x%2);
            x /= 2;
        }
        return new StringBuilder(ans).reverse().toString();
    }
    static int bin_to_dec(String s) {
        int ans = 0;
        for (char ch : s.toCharArray()) {
            ans = ans * 2 + (ch - '0');
        }
        return ans;
    }
    static String convert_to_bin(String s) {
        String a = "";
        for (String ip : s.split("\\.")) { // String.split(regex, limit)
            a += zfill(dec_to_bin(Integer.parseInt(ip)),8);
        }
        return a;
    }
    static String convert_to_ip(String a) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i=0; i<4; i++) {
            String ip = a.substring(i*8, i*8+8);
            ans.add(Integer.toString(bin_to_dec(ip)));
        }
        return String.join(".", ans);
    }
    static int longest_common_prefix(String[] ips) {
        int p = -1;
        for (int i=0; i<32; i++) {
            boolean ok = true;
            for (String ip : ips) {
                if (ip.charAt(i) != ips[0].charAt(i)) {
                    ok = false;
                }
            }
            if (ok) {
                p = i;
            } else {
                break;
            }
        }
        return p;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ips = new String[n];
        for (int i=0; i<n; i++) {
            String ip = sc.next();
            ips[i] = convert_to_bin(ip);
        }
        int p = longest_common_prefix(ips);
        String ip = ips[0];
        String network_address = "";
        String network_mask = "";
        for (int i=0; i<32; i++) {
            network_address += (i <= p ? ip.charAt(i) : '0');
            network_mask += (i <= p ? '1' : '0');
        }
        System.out.println(convert_to_ip(network_address));
        System.out.println(convert_to_ip(network_mask));
    }
}