
class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0){
                int row = yellow / i + 2;
                int colum = i + 2;
                if (brown == (row - 2) * 2 + (colum * 2))
                    return new int[]{row, colum};
            }
        }
        return null;
    }
}