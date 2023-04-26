class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        
        for(int[] size : sizes){
            if(size[0] < size[1]){
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
            
            width = Math.max(width, size[0]);
            height = Math.max(height, size[1]);
        }
        
        return width * height;
    }
}