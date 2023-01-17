import java.util.*;

class Solution {
    private final HashMap<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] infos, String[] query) {
        int[] answer = new int[query.length];

        for (String info : infos) {
            dfs(info.split(" "), "", 0);
        }

        for (String key : map.keySet())
            Collections.sort(map.get(key));

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i]
                    .replaceAll(" and ", "")
                    .split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }


    private int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return list.size() - start;
    }

    private void dfs(String[] p, String str, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        dfs(p, str + "-", cnt + 1);
        dfs(p, str + p[cnt], cnt + 1);
    }
}