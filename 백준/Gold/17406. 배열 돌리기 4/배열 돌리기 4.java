import java.util.*;

class Tuple implements Comparable<Tuple> {
    int row, col, size;
    int index;
    Tuple(int row, int col, int size, int index) {
        this.row = row;
        this.col = col;
        this.size = size;
        this.index = index;
    }
    public int compareTo(Tuple that) {
        if (this.index < that.index) {
            return -1;
        } else if (this.index == that.index) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class Main {
    static boolean next_permutation(Tuple[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1].compareTo(a[i]) >= 0) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j].compareTo(a[i-1]) <= 0) {
            j -= 1;
        }

        Tuple temp = a[i-1];
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
    static void go(int[][] a, Tuple t) {
        int row = t.row;
        int col = t.col;
        int size = t.size;
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        for (int s=1; s<=size; s++) {
            ArrayList<Integer> group = new ArrayList<>();
            // (r-s, c-s) -> (r-s, c+s)
            for (int r=row-s, c=col-s; c<col+s; c++) {
                group.add(a[r][c]);
            }
            // (r-s, c+s) -> (r+s, c+s)
            for (int r=row-s, c=col+s; r<row+s; r++) {
                group.add(a[r][c]);
            }
            // (r+s, c+s) -> (r+s, c-s)
            for (int r=row+s, c=col+s; c>col-s; c--) {
                group.add(a[r][c]);
            }
            // (r+s, c-s) -> (r-s, c-s)
            for (int r=row+s, c=col-s; r>row-s; r--) {
                group.add(a[r][c]);
            }
            groups.add(group);
        }
        for (int s=1; s<=size; s++) {
            ArrayList<Integer> group = groups.get(s-1);
            Collections.rotate(group, 1);
            int len = group.size();
            int index = 0;
            // (r-s, c-s) -> (r-s, c+s)
            for (int r=row-s, c=col-s; c<col+s; c++) {
                a[r][c] = group.get(index++);
            }
            // (r-s, c+s) -> (r+s, c+s)
            for (int r=row-s, c=col+s; r<row+s; r++) {
                a[r][c] = group.get(index++);
            }
            // (r+s, c+s) -> (r+s, c-s)
            for (int r=row+s, c=col+s; c>col-s; c--) {
                a[r][c] = group.get(index++);
            }
            // (r+s, c-s) -> (r-s, c-s)
            for (int r=row+s, c=col-s; r>row-s; r--) {
                a[r][c] = group.get(index++);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        Tuple[] d = new Tuple[k];
        for (int i=0; i<k; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            int s = sc.nextInt();
            d[i] = new Tuple(r, c, s, i);
        }
        int ans = 100*100;
        do {
            int[][] b = new int[n][m];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    b[i][j] = a[i][j];
                }
            }
            for (Tuple t : d) {
                go(b, t);
            }
            for (int i=0; i<n; i++) {
                int sum = 0;
                for (int j=0; j<m; j++) {
                    sum += b[i][j];
                }
                if (ans > sum) ans = sum;
            }
        } while (next_permutation(d));
        System.out.println(ans);
    }
}