import java.util.*;

public class Main {
    static final int n = 33;
    static int[] score = {
        0,2,4,6,8,
        10,13,16,19,25,
        12,14,16,18,20,
        22,24,22,24,26,
        28,26,27,28,30,
        32,34,36,38,30,
        35,40,0
    };
    static final int t = 10;
    static int[] dice = new int[t];
    static int[][] a = new int[n][];
    static int get_next(int start, int k) {
        int now = start;
        for (int i=0; i<k; i++) {
            if (i == 0) {
                now = a[now][0];
            } else {
                now = a[now][1];
            }
        }
        return now;
    }
    static int go(int index, int[] horse, int sum) {
        if (index == t) return sum;
        int ans = 0;
        for (int i=0; i<4; i++) {
            int nxt = get_next(horse[i], dice[index]);
            boolean ok = true;
            if (nxt != n-1) {
                for (int j=0; j<4; j++) {
                    if (i == j) continue;
                    if (nxt == horse[j]) ok = false;
                }
            }
            if (ok) {
                int[] nhorse = horse.clone();
                nhorse[i] = nxt;
                int temp = go(index+1, nhorse, sum+score[nxt]);
                if (ans < temp) ans = temp;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a[0] = new int[]{1,1};
        a[1] = new int[]{2,2};
        a[2] = new int[]{3,3};
        a[3] = new int[]{4,4};
        a[4] = new int[]{5,5};
        a[5] = new int[]{6,10};
        a[6] = new int[]{7,7};
        a[7] = new int[]{8,8};
        a[8] = new int[]{9,9};
        a[9] = new int[]{29,29};
        a[10] = new int[]{11,11};
        a[11] = new int[]{12,12};
        a[12] = new int[]{13,13};
        a[13] = new int[]{14,14};
        a[14] = new int[]{15,17};
        a[15] = new int[]{16,16};
        a[16] = new int[]{9,9};
        a[17] = new int[]{18,18};
        a[18] = new int[]{19,19};
        a[19] = new int[]{20,20};
        a[20] = new int[]{24,24};
        a[21] = new int[]{9,9};
        a[22] = new int[]{21,21};
        a[23] = new int[]{22,22};
        a[24] = new int[]{23,25};
        a[25] = new int[]{26,26};
        a[26] = new int[]{27,27};
        a[27] = new int[]{28,28};
        a[28] = new int[]{31,31};
        a[29] = new int[]{30,30};
        a[30] = new int[]{31,31};
        a[31] = new int[]{32,32};
        a[32] = new int[]{32,32};
        for (int i=0; i<t; i++) {
            dice[i] = sc.nextInt();
        }
        System.out.println(go(0, new int[]{0, 0, 0, 0}, 0));
    }
}