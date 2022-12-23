import java.util.*;

class Solution {
    private List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1,3, 2);

        int[][] answer = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private void hanoi(int n, int start, int to, int mid) {
        if(n == 1){
            list.add(new int[]{start, to});
            return;
        }
        hanoi(n-1, start, mid, to);
        list.add(new int[]{start, to});
        hanoi(n-1, mid, to, start);
    }
}