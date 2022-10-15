import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] check = new boolean[n][m];
        char[][] a = new char[n][m];
        for (int i=0; i<n; i++) {
            a[i] = sc.next().toCharArray();
        }
        ArrayList<Integer> ans_x = new ArrayList<>();
        ArrayList<Integer> ans_y = new ArrayList<>();
        ArrayList<Integer> ans_l = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == '*') {
                    int l = 0;
                    for (int k=1;; k++) {
                        if (i+k < n && i-k >= 0 && j+k < m && j-k >= 0) {
                            if (a[i+k][j] == '*' && a[i-k][j] == '*' && a[i][j+k] == '*' && a[i][j-k] == '*') {
                                l = k;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (l > 0) {
                        ans_x.add(i+1);
                        ans_y.add(j+1);
                        ans_l.add(l);
                        check[i][j] = true;
                        for (int k=1; k<=l; k++) {
                            check[i+k][j] = true;
                            check[i-k][j] = true;
                            check[i][j-k] = true;
                            check[i][j+k] = true;
                        }
                    }
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == '*' && check[i][j] == false) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(ans_x.size());
        for (int i=0; i<ans_x.size(); i++) {
            int x = ans_x.get(i);
            int y = ans_y.get(i);
            int l = ans_l.get(i);
            System.out.println(x + " " + y + " " + l);
        }
    }
}