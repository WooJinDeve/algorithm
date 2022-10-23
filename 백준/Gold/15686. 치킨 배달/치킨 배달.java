import java.util.*;
class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
} 
public class Main {
    static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][n];
        ArrayList<Pair> people = new ArrayList<>();
        ArrayList<Pair> store = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 1) {
                    people.add(new Pair(i,j));
                } else if (a[i][j] == 2) {
                    store.add(new Pair(i,j));
                }
            }
        }
        int[] d = new int[store.size()];
        for (int i=0; i<m; i++) {
            d[i] = 1;
        }
        Arrays.sort(d);
        int ans = -1;
        do {
            int sum = 0;
            for (Pair p : people) {
                int min = -1;
                for (int i=0; i<store.size(); i++) {
                    if (d[i] == 0) continue;
                    Pair s = store.get(i);
                    int d1 = p.first-s.first;
                    int d2 = p.second-s.second;
                    if (d1 < 0) d1 = -d1;
                    if (d2 < 0) d2 = -d2;
                    int dist = d1+d2;
                    if (min == -1 || min > dist) {
                        min = dist;
                    }
                }
                sum += min; 
            }
            if (ans == -1 || ans > sum) {
                ans = sum;
            }
        } while (next_permutation(d));
        System.out.println(ans);
    }
}