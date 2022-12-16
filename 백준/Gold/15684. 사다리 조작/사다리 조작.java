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
    static int[][] garo = new int[100][100];
    static int w, h;
    static int start(int c) {
        int r = 1;
        while (r <= h) {
            if (garo[r][c] == 1) {
                c += 1;
            } else if (garo[r][c] == 2) {
                c -= 1;
            }
            r += 1;
        }
        return c;
    }
    static boolean go() {
        for (int i=1; i<=w; i++) {
            int res = start(i);
            if (res != i) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m;
        w = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            garo[x][y] = 1;
            garo[x][y+1] = 2;
        }
        ArrayList<Pair> temp = new ArrayList<>();
        for (int i=1; i<=h; i++) {
            for (int j=1; j<=w-1; j++) {
                if (garo[i][j] != 0) continue;
                if (garo[i][j+1] != 0) continue;
                temp.add(new Pair(i,j));
            }
        }
        Pair[] a = temp.toArray(new Pair[temp.size()]);
        int ans = -1;
        if (go()) {
            System.out.println(0);
            System.exit(0);
        }
        int len = a.length;
        for (int i=0; i<len; i++) {
            int x1 = a[i].first;
            int y1 = a[i].second;
            if (garo[x1][y1] != 0 || garo[x1][y1+1] != 0) continue;
            garo[x1][y1] = 1;
            garo[x1][y1+1] = 2;
            if (go()) {
                if (ans == -1 || ans > 1) {
                    ans = 1;
                }
            }
            for (int j=i+1; j<len; j++) {
                int x2 = a[j].first;
                int y2 = a[j].second;
                if (garo[x2][y2] != 0 || garo[x2][y2+1] != 0) continue;
                garo[x2][y2] = 1;
                garo[x2][y2+1] = 2;
                if (go()) {
                    if (ans == -1 || ans > 2) {
                        ans = 2;
                    }
                }
                for (int k=j+1; k<len; k++) {
                    int x3 = a[k].first;
                    int y3 = a[k].second;
                    if (garo[x3][y3] != 0 || garo[x3][y3+1] != 0) continue;
                    garo[x3][y3] = 1;
                    garo[x3][y3+1] = 2;
                    if (go()) {
                        if (ans == -1 || ans > 3) {
                            ans = 3;
                        }
                    }
                    garo[x3][y3] = 0;
                    garo[x3][y3+1] = 0;
                }
                garo[x2][y2] = 0;
                garo[x2][y2+1] = 0;
            }
            garo[x1][y1] = 0;
            garo[x1][y1+1] = 0;
        }
        System.out.println(ans);
    }
}