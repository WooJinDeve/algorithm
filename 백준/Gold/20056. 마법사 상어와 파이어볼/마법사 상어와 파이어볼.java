import java.util.*;
class Shark {
    int m, s, d;
    Shark(int m, int s, int d) {
        this.m = m;
        this.s = s;
        this.d = d;
    }
}
public class Main {
    static final int[] dx = {-1,-1,0,1,1,1,0,-1};
    static final int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Shark>[][] a = new ArrayList[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = new ArrayList<>();
            }
        }
        for (int i=0; i<m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int _m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            r -= 1;
            c -= 1;
            a[r][c].add(new Shark(_m,s,d));
        }
        for (int l=0; l<k; l++) {
            ArrayList<Shark>[][] b = new ArrayList[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    b[i][j] = new ArrayList<>();
                }
            }
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    for (Shark shark : a[i][j]) {
                        int x = i+dx[shark.d]*shark.s;
                        int y = j+dy[shark.d]*shark.s;
                        x = (x % n + n) % n;
                        y = (y % n + n) % n;
                        b[x][y].add(shark);
                    }
                }
            }
            a = b;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (a[i][j].size() > 1) {
                        int total_m = 0;
                        int total_s = 0;
                        int cnt = a[i][j].size();
                        int compare_d = a[i][j].get(0).d%2;
                        int result_d = 0;
                        for (Shark shark : a[i][j]) {
                            if (shark.d % 2 != compare_d) {
                                result_d = 1;
                            }
                            total_m += shark.m;
                            total_s += shark.s;
                        }
                        a[i][j].clear();
                        int shark_m = total_m/5;
                        int shark_s = total_s/cnt;
                        if (shark_m > 0) {
                            for (int dir=0; dir<4; dir++) {
                                a[i][j].add(new Shark(shark_m,shark_s,dir*2+result_d));
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (Shark shark : a[i][j]) {
                    ans += shark.m;
                }
            }
        }
        System.out.println(ans);
    }
}