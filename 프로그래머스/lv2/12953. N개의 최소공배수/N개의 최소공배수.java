import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int[] copy = new int[arr.length];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, copy, 0, arr.length);

        while (true) {
            boolean ok = true;
            for (int j = 1; j < copy.length; j++) {
                if (copy[j] == copy[0])
                    continue;
                
                if (copy[j] > copy[0]) copy[0] += arr[0];
                else copy[j] += arr[j];
                ok = false;
            }

            if (ok)
                break;
        }

        return copy[0];
    }
}