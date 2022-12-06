class Solution {
    StringBuilder sb = new StringBuilder();
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        QuadTree(answer, arr, 0, 0, arr.length);
        return answer;
    }
    
    private void QuadTree(int[] answer, int[][] arr, int x, int y, int size){
        if (isPossible(arr, x, y, size)) {
            if(arr[x][y] == 0){
                answer[0]++;
            }else
                answer[1]++;
            return;
        }

        int newSize = size / 2;

        QuadTree(answer, arr, x, y, newSize);
        QuadTree(answer, arr, x, y+newSize, newSize);
        QuadTree(answer, arr, x+newSize, y, newSize);
        QuadTree(answer, arr, x+newSize, y+newSize, newSize);
    }
    
    private boolean isPossible(int[][] arr, int x, int y, int size){
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}