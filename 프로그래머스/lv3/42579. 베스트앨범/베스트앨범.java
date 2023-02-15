import java.util.*;

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> playlist = new HashMap<>();
        Map<String, Long> playCount = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!playlist.containsKey(genres[i])) {
                playlist.put(genres[i], new ArrayList<>());
            }
            playlist.get(genres[i]).add(new int[]{i, plays[i]});
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0L) + plays[i]);
        }

        List<String> sortedPlayList = new ArrayList<>(playCount.keySet());
        sortedPlayList.sort((o1, o2) -> playCount.get(o2).compareTo(playCount.get(o1)));

        List<Integer> answer = new ArrayList<>();
        for (String key : sortedPlayList) {

            List<int[]> music = playlist.get(key);
            music.sort(((o1, o2) -> o2[1] - o1[1]));

            for (int i = 0; i < 2; i++) {
                if (music.size() > i)
                    answer.add(music.get(i)[0]);
            }
        }

        return answer.stream()
                .mapToInt(i ->i)
                .toArray();
    }
}