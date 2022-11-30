import java.util.*;
public class Main {
    static boolean is_complete(char[][] a) {
        int goal = 0;
        int box = 0;
        for (char[] row : a) {
            for (char ch : row) {
                if (ch == '+') goal += 1;
                if (ch == 'b') box += 1;
            }
        }
        return (goal == 0 && box == 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;
            char[][] a = new char[n][];
            int x = 0;
            int y = 0;
            for (int i=0; i<n; i++) {
                String line = sc.next();
                a[i] = line.toCharArray();
                for (int j=0; j<m; j++) {
                    if (a[i][j] == 'w' || a[i][j] == 'W') {
                        x = i;
                        y = j;
                    }
                }
            }
            String s = sc.next();
            for (char ch : s.toCharArray()) {
                int dx = 0;
                int dy = 0;
                if (ch == 'U') dx = -1;
                if (ch == 'D') dx = 1;
                if (ch == 'L') dy = -1;
                if (ch == 'R') dy = 1;
                int nx = x+dx;
                int ny = y+dy;
                if (a[nx][ny] == '#') { // 벽
                } else if (a[nx][ny] == '.' || a[nx][ny] == '+') { // 빈 공간, 비어 있는 목표점
                    if (a[nx][ny] == '.') { // 빈 공간
                        a[nx][ny] = 'w';
                    } else { // 비어 있는 목표점
                        a[nx][ny] = 'W';
                    }
                    if (a[x][y] == 'w') { // 빈 공간 위에 있는 캐릭터
                        a[x][y] = '.';
                    } else { // 목표점 위에 있는 캐릭터
                        a[x][y] = '+';
                    }
                    x = nx;
                    y = ny;
                } else if (a[nx][ny] == 'b' || a[nx][ny] == 'B') { // 벽
                    boolean ok = true;
                    int nx2 = nx + dx;
                    int ny2 = ny + dy;
                    // (x, y) -> (nx, ny) -> (nx2, ny2)
                    // 가장 바깥쪽 칸은 항상 벽이다.
                    if (a[nx2][ny2] == '#') ok = false;
                    if (a[nx2][ny2] == 'b') ok = false;
                    if (a[nx2][ny2] == 'B') ok = false;
                    if (ok) {
                        if (a[nx2][ny2] == '.') { // 빈 공간
                            a[nx2][ny2] = 'b';
                        } else { // 비어 있는 목표점
                            a[nx2][ny2] = 'B';
                        }
                        if (a[nx][ny] == 'b') { // 박스
                            a[nx][ny] = 'w';
                        } else { // 목표점 위에 있는 박스
                            a[nx][ny] = 'W';
                        }
                        if (a[x][y] == 'w') {
                            a[x][y] = '.';
                        } else {
                            a[x][y] = '+';
                        }
                        x = nx;
                        y = ny;
                    }
                }
                if (is_complete(a)) { // 게임이 끝난 후에 입력하는 키는 모두 무시된다.
                    break;
                }
            }
            System.out.print("Game " + tc + ": ");
            System.out.println(is_complete(a) ? "complete" : "incomplete");
            for (char[] row : a) {
                for (char ch : row) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            tc += 1;
        }
    }
}