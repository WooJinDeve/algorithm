import java.util.*;
import java.util.Map.Entry;
class Pair implements Comparable<Pair> {
    int num, cnt;
    Pair(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
    public int compareTo(Pair that) {
        if (this.cnt < that.cnt) {
            return -1;
        } else if (this.cnt == that.cnt) {
            if (this.num < that.num) {
                return -1;
            } else if (this.num == that.num) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3, m = 3;
        int[][] a = new int[100][100];
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        int k = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        if (a[r][c] == k) {
            System.out.println(0);
            System.exit(0);
        }
        for (int t=1; t<=100; t++) {
            if (n >= m) {
                int mm = m;
                for (int i=0; i<n; i++) {
                    HashMap<Integer, Integer> d = new HashMap<>();
                    for (int j=0; j<m; j++) {
                        if (a[i][j] == 0) continue;
                        int val = 0;
                        if (d.containsKey(a[i][j])) {
                            val = d.get(a[i][j]);
                        }
                        val += 1;
                        d.put(a[i][j], val);
                    }
                    ArrayList<Pair> v = new ArrayList<>();
                    for (Entry<Integer, Integer> e : d.entrySet()) {
                        v.add(new Pair(e.getKey(), e.getValue()));
                    }
                    Collections.sort(v);
                    int l = Math.min((int)v.size(), 50);
                    for (int j=0; j<l; j++) {
                        a[i][j*2] = v.get(j).num;
                        a[i][j*2+1] = v.get(j).cnt;
                    }
                    for (int j=l*2; j<100; j++) {
                        a[i][j] = 0;
                    }
                    if (mm < (int)v.size()*2) {
                        mm = (int)v.size()*2;
                    }
                }
                m = mm;
            } else {
                int nn = n;
                for (int j=0; j<m; j++) {
                    HashMap<Integer, Integer> d = new HashMap<>();
                    for (int i=0; i<n; i++) {
                        if (a[i][j] == 0) continue;
                        int val = 0;
                        if (d.containsKey(a[i][j])) {
                            val = d.get(a[i][j]);
                        }
                        val += 1;
                        d.put(a[i][j], val);
                    }
                    ArrayList<Pair> v = new ArrayList<>();
                    for (Entry<Integer, Integer> e : d.entrySet()) {
                        v.add(new Pair(e.getKey(), e.getValue()));
                    }
                    Collections.sort(v);
                    int l = Math.min((int)v.size(), 50);
                    for (int i=0; i<l; i++) {
                        a[i*2][j] = v.get(i).num;
                        a[i*2+1][j] = v.get(i).cnt;
                    }
                    for (int i=l*2; i<100; i++) {
                        a[i][j] = 0;
                    }
                    if (nn < (int)v.size()*2) {
                        nn = (int)v.size()*2;
                    }
                }
                n = nn;
            }
            if (a[r][c] == k) {
                System.out.println(t);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}