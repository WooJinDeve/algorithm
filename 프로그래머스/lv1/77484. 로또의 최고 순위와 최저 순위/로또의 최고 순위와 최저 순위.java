class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
   int high, row;
        high = row = 7;

        for (int lotto : lottos) {
            if (lotto == 0)
                high--;
            else {
                for (int win_num : win_nums) {
                    if (lotto == win_num){
                        row--;
                        high--;
                    }
                }
            }
        }

        high = Math.min(high, 6);
        row = Math.min(row, 6);
        return new int[]{high, row};
    }
}