import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] files) {
        List<File> filesList = Arrays.stream(files)
                .map(File::new)
                .sorted()
                .collect(Collectors.toList());

        return filesList.stream()
                .map(f -> f.fullName)
                .toArray(String[]::new);
    }



    class File implements Comparable<File>{
        private final String head;
        private final int number;
        private final String fullName;

        public File(String fullName) {
            String num = indexAndSize(fullName);
            int idx = fullName.indexOf(num);

            this.head = fullName.substring(0, idx).toUpperCase();
            this.number = Integer.parseInt(num.substring(0, Math.min(5, num.length())));
            this.fullName = fullName;
        }

        private String indexAndSize(String fileName) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < fileName.length(); i++) {
                int length = sb.length();
                int num = fileName.charAt(i) - '0';
                if (num >= 0 && num <= 9){
                    sb.append(num);
                }
                
                if (length == 0 || length < sb.length())
                    continue;
                return sb.toString();
            }
            return sb.toString();
        }

        @Override
        public int compareTo(File file){
            int compare = this.head.compareTo(file.head);
            if (compare != 0)
                return compare;
            return this.number - file.number;
        }
    }
}