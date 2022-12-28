import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)
            return cities.length * 5;

        List<String> cache = new LinkedList<>();
        int ans = 0;

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.contains(city)){
                ans += 1;
                cache.remove(city);
                cache.add(0, city);
                continue;
            }
            ans += 5;
            if (cacheSize == cache.size()){
                cache.remove(cache.size() - 1);
            }
            if (cacheSize > cache.size())
                cache.add(0, city);
        }

        return ans;
    }
}