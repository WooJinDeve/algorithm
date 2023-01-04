import java.text.*;
import java.util.*;

class Solution {
     public String solution(String m, String[] musicinfos) {
        List<Music> musicList = new ArrayList<>();
        List<Music> result = new ArrayList<>();


        for (String musicinfo : musicinfos) {
            String[] musicInfo = musicinfo.split(",");
            Music music = new Music(musicInfo[2], musicInfo[0], musicInfo[1], musicInfo[3]);
            musicList.add(music);
        }

        m = convertToSharp(m);

        for (Music music : musicList) {
            if (music.content.contains(m)){
                result.add(music);
            }
        }

        if (result.isEmpty())
            return "(None)";

        result.sort((o1, o2) -> o2.count - o1.count);
        return result.get(0).title;
    }

    private String convertToSharp(String str) {
        return str.replace("C#", "Q")
                .replace("D#", "W")
                .replace("F#", "R")
                .replace("G#", "T")
                .replace("A#", "Y");
    }

    class Music {

        private String title;
        private int count;
        private String content;

        public Music(String title, String firstTime, String lastTime, String content) {
            this.title = title;
            this.count = convertToCount(firstTime, lastTime);
            this.content = verifyContent(convertToSharp(content));
        }

        private String verifyContent(String content){
            int repeat = count / content.length();
            content = content.substring(0, Math.min(content.length(), count));
            if (repeat == 0)
                return content;
            return content.repeat(repeat + 1);
        }

        private int convertToCount(String firstTime, String lastTime) {
            try {
                DateFormat formatter = new SimpleDateFormat("HH:mm");
                Date firstDate  = formatter.parse(firstTime);
                Date lastDate = formatter.parse(lastTime);
                System.out.println((lastDate.getTime() - firstDate.getTime()) / (1000 * 60));
                return (int)(lastDate.getTime() - firstDate.getTime()) / (1000 * 60);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}