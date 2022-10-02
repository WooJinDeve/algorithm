import java.util.*;
class Fish {
    int size, speed, direction;
    Fish(int size, int speed, int direction) {
        this.size = size;
        this.speed = speed;
        this.direction = direction;
    }
    Fish(Fish that) {
        this.size = that.size;
        this.speed = that.speed;
        this.direction = that.direction;
    }
}
class Tuple {
    int row, col, direction;
    Tuple(int row, int col, int direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }
}
public class Main {
    // up, down, right, left
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int n, m;
    static Fish[][] fish;
    static Fish[][] nfish;
    static Tuple get_next(int x, int y, int speed, int direction) {
        for (int k=0; k<speed; k++) {
            if (direction == 0) { // up
                if (x == 0) {
                    x = 1;
                    direction = 1;
                } else {
                    x -= 1;
                }
            } else if (direction == 1) { // down
                if (x == n-1) {
                    x = n-2;
                    direction = 0;
                } else {
                    x += 1;
                }
            } else if (direction == 2) { // right
                if (y == m-1) {
                    y = m-2;
                    direction = 3;
                } else {
                    y += 1;
                }
            } else if (direction == 3) { // left
                if (y == 0) {
                    y = 1;
                    direction = 2;
                } else {
                    y -= 1;
                }
            }
        }
        return new Tuple(x, y, direction);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        fish = new Fish[n][m];
        nfish = new Fish[n][m];
        int mm = sc.nextInt();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                fish[i][j] = new Fish(0,0,0);
                nfish[i][j] = new Fish(0,0,0);
            }
        }
        while (mm-- > 0) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int s = sc.nextInt();
            int d = sc.nextInt()-1;
            int z = sc.nextInt();
            if (d <= 1) {
                s %= (2*n-2);
            } else {
                s %= (2*m-2);
            }
            fish[x][y] = new Fish(z, s, d);
        }
        long ans = 0;
        for (int j=0; j<m; j++) {
            for (int i=0; i<n; i++) {
                if (fish[i][j].size > 0) {
                    ans += fish[i][j].size;
                    fish[i][j].size = 0;
                    break;
                }
            }
            for (int l1=0; l1<n; l1++) {
                for (int l2=0; l2<m; l2++) {
                    if (fish[l1][l2].size == 0) continue;
                    Fish f = fish[l1][l2];
                    Tuple temp = get_next(l1, l2, f.speed, f.direction);
                    int x = temp.row;
                    int y = temp.col;
                    int direction = temp.direction;
                    if (nfish[x][y].size == 0 || nfish[x][y].size < f.size) {
                        nfish[x][y] = new Fish(f.size, f.speed, direction);
                    }
                }
            }
            for (int l1=0; l1<n; l1++) {
                for (int l2=0; l2<m; l2++) {
                    fish[l1][l2] = new Fish(nfish[l1][l2]);
                    nfish[l1][l2].size = 0;
                }
            }
        }
        System.out.println(ans);
    }
}