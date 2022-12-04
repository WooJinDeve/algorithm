import java.util.*;
public class Main {
    static void clockwise(char[][] a) {
        int n = 3;
        // (0, 0) (0, 1) (0, 2)
        // (1, 0) (1, 1) (1, 2)
        // (2, 0) (2, 1) (2, 2)
        //          |
        //          v
        // (2, 0) (1, 0) (0, 0)
        // (2, 1) (1, 1) (0, 1)
        // (2, 2) (1, 2) (0, 2)
        char temp = a[0][0];
        a[0][0] = a[2][0];
        a[2][0] = a[2][2];
        a[2][2] = a[0][2];
        a[0][2] = temp;
        temp = a[0][1];
        a[0][1] = a[1][0];
        a[1][0] = a[2][1];
        a[2][1] = a[1][2];
        a[1][2] = temp;
    }
    static void U(char[][][] a) {
        // 0 -> 2 -> 5 -> 4
        int n = 3;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                char temp = a[0][i][j];
                a[0][i][j] = a[4][i][j];
                a[4][i][j] = a[5][i][j];
                a[5][i][j] = a[2][i][j];
                a[2][i][j] = temp;
            }
        }
        clockwise(a[5]); clockwise(a[5]);
        clockwise(a[4]); clockwise(a[4]);
        clockwise(a[1]);
        clockwise(a[3]); clockwise(a[3]); clockwise(a[3]);
    }
    static void F(char[][][] a) {
        // 1 -> 2 -> 3 -> 4
        int n = 3;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                char temp = a[1][i][j];
                a[1][i][j] = a[4][i][j];
                a[4][i][j] = a[3][i][j];
                a[3][i][j] = a[2][i][j];
                a[2][i][j] = temp;
            }
        }
        clockwise(a[2]); clockwise(a[2]); clockwise(a[2]);
        clockwise(a[3]); clockwise(a[3]); clockwise(a[3]);
        clockwise(a[4]); clockwise(a[4]); clockwise(a[4]);
        clockwise(a[1]); clockwise(a[1]); clockwise(a[1]);
        clockwise(a[0]); clockwise(a[0]); clockwise(a[0]);
        clockwise(a[5]);
    }
    static void L(char[][][] a) {
        // 0 -> 1 -> 5 -> 3
        for (int i=0; i<3; i++) {
            char temp = a[0][i][0];
            a[0][i][0] = a[3][i][0];
            a[3][i][0] = a[5][i][0];
            a[5][i][0] = a[1][i][0];
            a[1][i][0] = temp;
        }
        clockwise(a[4]);
    }
    static void R(char[][][] a) {
        // 0 -> 3 -> 5 -> 1
        for (int i=0; i<3; i++) {
            char temp = a[0][i][2];
            a[0][i][2] = a[1][i][2];
            a[1][i][2] = a[5][i][2];
            a[5][i][2] = a[3][i][2];
            a[3][i][2] = temp;
        }
        clockwise(a[2]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            char[][][] a = {
                {{'w','w','w'}, {'w','w','w'}, {'w','w','w'}},
                {{'r','r','r'}, {'r','r','r'}, {'r','r','r'}},
                {{'b','b','b'}, {'b','b','b'}, {'b','b','b'}},
                {{'o','o','o'}, {'o','o','o'}, {'o','o','o'}},
                {{'g','g','g'}, {'g','g','g'}, {'g','g','g'}},
                {{'y','y','y'}, {'y','y','y'}, {'y','y','y'}},
            };
            while (m-- > 0) {
                char[] s = sc.next().toCharArray();
                int k = 1;
                if (s[1] == '-') k = 3;

                if (s[0] == 'U') {
                    U(a);
                    for (int i=0; i<k; i++) R(a);
                    for (int i=0; i<3; i++) U(a);
                } else if (s[0] == 'D') {
                    U(a);
                    for (int i=0; i<k; i++) L(a);
                    for (int i=0; i<3; i++) U(a);
                } else if (s[0] == 'F') {
                    F(a);
                    for (int i=0; i<k; i++) R(a);
                    for (int i=0; i<3; i++) F(a);
                } else if (s[0] == 'B') {
                    F(a);
                    for (int i=0; i<k; i++) L(a);
                    for (int i=0; i<3; i++) F(a);
                } else if (s[0] == 'L') {
                    for (int i=0; i<k; i++) L(a);
                } else if (s[0] == 'R') {
                    for (int i=0; i<k; i++) R(a);
                }
            }
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    System.out.print(a[0][i][j]);
                }
                System.out.println();
            }
        }
    }
}