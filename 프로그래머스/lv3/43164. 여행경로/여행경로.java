import java.util.*;

class Solution {
    private static List<String> list = new ArrayList<>();
    private static Map<String, Integer> visited = new HashMap<>();
    
    public static String[] solution(String[][] tickets) {
        int n = tickets.length;
        Map<String, List<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.put(ticket[0], map.getOrDefault(ticket[0], new ArrayList<>()));
            map.get(ticket[0]).add(ticket[1]);
            visited.put(ticket[0] + ticket[1], visited.getOrDefault(ticket[0] + ticket[1], 0) + 1);
        }


        dfs(0, n, "ICN", "ICN", map);
        list.sort(Comparator.naturalOrder());

        return list.get(0).split(",");
    }

    private static void dfs(int depth, int n, String answer, String key, Map<String, List<String>> map) {
        if (depth == n) {
            list.add(answer);
            return;
        }

        if (map.get(key) == null) {
            return;
        }

        for (String root : map.get(key)) {
             if (visited.get(key + root) == null || visited.get(key + root) == 0)
                continue;
            visited.put(key + root, visited.get(key + root) - 1);
            dfs(depth + 1, n, answer + "," + root, root, map);
            visited.put(key + root, visited.get(key + root) + 1);
        }
    }
}