import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        int exit = 23 * 60 + 59;
        int baseTime = fees[0], baseFee= fees[1], fee = fees[3];
        double time = fees[2];

        for(String record : records){  //map1에 records 입력
            String[] re = record.split(" ");
            int carNum = Integer.valueOf(re[1]);
            int min = Integer.valueOf(re[0].substring(3,5))
                    + Integer.valueOf(re[0].substring(0,2)) * 60;

            if(re[2].equals("IN")) map1.put(carNum, min);
            else{
                map2.put(carNum,map2.getOrDefault(carNum, 0) + min - map1.get(carNum));
                map1.remove(carNum);
            }
        }

        for(int key : map1.keySet())
            map2.put(key,map2.getOrDefault(key, 0) + exit - map1.get(key));

        for(int key : map2.keySet())
            pq.add(key);

        int[] ans = new int[map2.size()];
        for(int i = 0; i < ans.length; i ++){
            int overTime = map2.get(pq.poll()) - baseTime;;
            if(overTime <= 0) overTime = 0;
            ans[i] = baseFee + (int)Math.ceil(overTime / time) * fee;
        }

        return ans;
    }
}