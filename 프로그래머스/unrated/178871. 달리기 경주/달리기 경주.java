import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranking = new HashMap<>();
        IntStream.range(0, players.length).forEach(i -> ranking.put(players[i], i));

        for (String calling : callings) {
            Integer idx = ranking.get(calling);
            ranking.put(players[idx], idx - 1);
            ranking.put(players[idx - 1], idx);
            swap(idx, players);
        }
        return players;
    }

    private static void swap(int i, String[] players){
        String temp = players[i];
        players[i] = players[i -1];
        players[i - 1] = temp;
    }
}