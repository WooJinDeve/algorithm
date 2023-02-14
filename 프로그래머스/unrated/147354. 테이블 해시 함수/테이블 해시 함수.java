import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            int i = o1[col - 1] - o2[col - 1];
            return i == 0 ? o2[0] - o1[0] : i;
        });

        List<Integer> values = new ArrayList<>();

        for (int i = row_begin - 1; i < row_end; i++) {
            int[] row = data[i];
            int value = 0;
            for (int element : row) {
                value += element % (i+1);
            }
            values.add(value);
        }

        Integer answer = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            answer = answer ^ values.get(i);
        }

        return answer;
    }
}