class Solution {
    public int solution(int[] common) {
        if(common[1] - common[0] == common[2] - common[1]) {
            int d = common[1] - common[0];
            return common[common.length - 1] + d;
        }
        int d = common[1] / common[0];
        return common[common.length - 1] * d;
    }
}