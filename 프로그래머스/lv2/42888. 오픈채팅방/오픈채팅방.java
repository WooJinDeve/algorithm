import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String, User> map = new HashMap<>();
        for (String str : record) {
            String[] split = str.split(" ");
            if (split[0].equals("Leave"))
                continue;

            if (map.containsKey(split[1])){
                User user = map.get(split[1]);
                user.setName(split[2]);
            }else {
                map.put(split[1], new User(split[2]));
            }
        }

        for (String s : record) {
            String[] split = s.split(" ");
            if (split[0].equals("Change"))
                continue;

            User user = map.get(split[1]);
            String insert = split[0].equals("Enter") ? user.enter() : user.leave();
            list.add(insert);
        }

        int size = list.size();
        return list.toArray(new String[size]);
    }

    class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String enter(){
            return this.name + "님이 들어왔습니다.";
        }

        public String leave(){
            return this.name + "님이 나갔습니다.";
        }
    }
}