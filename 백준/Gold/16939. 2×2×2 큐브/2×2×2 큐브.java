import java.util.*;
public class Main {
    final static int n = 24;
    static boolean check(int[] a) {
        for (int i=0; i<6; i++) {
            for (int j=0; j<4; j++) {
                if (a[i*4+1] != a[i*4+j+1]) return false;
            }
        }
        return true;
    }
    static int[] lu(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        int temp = a[1];
        a[1] = a[5];
        a[5] = a[9];
        a[9] = a[24];
        a[24] = temp;
        temp = a[3];
        a[3] = a[7];
        a[7] = a[11];
        a[11] = a[22];
        a[22] = temp;
        return a;
    }
    static int[] ld(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        a = lu(a);
        a = lu(a);
        a = lu(a);
        return a;
    }
    static int[] ru(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        int temp = a[2];
        a[2] = a[6];
        a[6] = a[10];
        a[10] = a[23];
        a[23] = temp;
        temp = a[4];
        a[4] = a[8];
        a[8] = a[12];
        a[12] = a[21];
        a[21] = temp;
        return a;
    }
    static int[] rd(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        a = ru(a);
        a = ru(a);
        a = ru(a);
        return a;
    }
    static int[] ul(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        int temp = a[13];
        a[13] = a[5];
        a[5] = a[17];
        a[17] = a[21];
        a[21] = temp;
        temp = a[14];
        a[14] = a[6];
        a[6] = a[18];
        a[18] = a[22];
        a[22] = temp;
        return a;
    }
    static int[] ur(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        a = ul(a);
        a = ul(a);
        a = ul(a);
        return a;
    }
    static int[] dl(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        int temp = a[15];
        a[15] = a[7];
        a[7] = a[19];
        a[19] = a[23];
        a[23] = temp;
        temp = a[16];
        a[16] = a[8];
        a[8] = a[20];
        a[20] = a[24];
        a[24] = temp;
        return a;
    }
    static int[] dr(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        a = dl(a);
        a = dl(a);
        a = dl(a);
        return a;
    }
    static int[] fl(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        int temp = a[3];
        a[3] = a[17];
        a[17] = a[10];
        a[10] = a[16];
        a[16] = temp;
        temp = a[4];
        a[4] = a[19];
        a[19] = a[9];
        a[9] = a[14];
        a[14] = temp;
        return a;
    }
    static int[] fr(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        a = fl(a);
        a = fl(a);
        a = fl(a);
        return a;
    }
    static int[] bl(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        int temp = a[1];
        a[1] = a[18];
        a[18] = a[12];
        a[12] = a[15];
        a[15] = temp;
        temp = a[2];
        a[2] = a[20];
        a[20] = a[11];
        a[11] = a[13];
        a[13] = temp;
        return a;
    }
    static int[] br(int[] b) {
        int[] a = Arrays.copyOf(b, b.length);
        a = bl(a);
        a = bl(a);
        a = bl(a);
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }
        if (check(lu(a)) || check(ld(a)) || check(ru(a)) || check(rd(a))) {
            System.out.println(1);
            System.exit(0);
        }
        if (check(ul(a)) || check(ur(a)) || check(dl(a)) || check(dr(a))) {
            System.out.println(1);
            System.exit(0);
        }
        if (check(fl(a)) || check(fr(a)) || check(bl(a)) || check(br(a))) {
            System.out.println(1);
            System.exit(0);
        }
        System.out.println(0);
    }
}