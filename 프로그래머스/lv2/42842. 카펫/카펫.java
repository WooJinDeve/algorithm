import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        List<Integer> yellows = measure(yellow);
        for (int i = 0; i < yellows.size() - 1; i++) {
            int row = yellows.get(i + 1) + 2;
            int colum = yellows.get(i) + 2;
            if (brown == (row - 2) * 2 + (colum * 2))
                return new int[]{row, colum};
        }
        return null;
    }
    
        public static List<Integer> measure(int x){
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0){
                arr.add(i);
                arr.add(x / i);
            }
        }
        return arr;
    }
}