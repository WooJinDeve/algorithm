import java.util.*;
public class Main {
    static String[] nums = {
        "###...#.###.###.#.#.###.###.###.###.###",
        "#.#...#...#...#.#.#.#...#.....#.#.#.#.#",
        "#.#...#.###.###.###.###.###...#.###.###",
        "#.#...#.#.....#...#...#.#.#...#.#.#...#",
        "###...#.###.###...#.###.###...#.###.###"
    };
    static boolean possible(String[] a, int x, int y) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<3; j++) {
                if (nums[i].charAt(4*y+j) == '.' && a[i].charAt(4*x+j) == '#') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[5];
        for (int i=0; i<5; i++) {
            a[i] = sc.next();
        }
        ArrayList<Integer>[] candidate = new ArrayList[n];
        for (int i=0; i<n; i++) {
            candidate[i] = new ArrayList<>();
            for (int j=0; j<10; j++) {
                if (possible(a, i, j)) {
                    candidate[i].add(j);
                }
            }
        }
        long total = 1;
        // total = candidate[0] * ... * candidate[n-1]
        for (int i=0; i<n; i++) {
            total *= candidate[i].size();
        }
        if (total == 0) {
            System.out.println(-1);
            System.exit(0);
        }
        long sum = 0;
        for (int i=0; i<n; i++) {
            long cur = 0;
            for (int x : candidate[i]) {
                cur += x;
            }
            sum = sum * 10 + cur * (total / candidate[i].size());
        }
        System.out.printf("%.10f\n", (double)sum / total);
    }
}