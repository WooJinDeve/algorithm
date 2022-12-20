import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> pb = new HashSet<>();
        Set<Integer> size = new HashSet<>();

        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        for (String phone : phone_book) {
            size.add(phone.length());
            for (Integer s : size) {
                String ph = phone.substring(0, s);
                if (!pb.add(ph))
                    return false;
                pb.remove(ph);
            }
            pb.add(phone);
        }
        return true;
    }
}