import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(Integer num : nums){
            hashSet.add(num);
        }
        
        return nums.length / 2 < hashSet.size() ? nums.length / 2 : hashSet.size();
    }
}