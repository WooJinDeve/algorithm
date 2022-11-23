import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1}; 
    static int[] dy = {-1, 1, 0, 0};
    static int[][] check;
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[][] posits = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        String[][] pad = {{"L", "", "R"}, {"L", "", "R"}, {"L", "", "R"}, {"L", "", "R"}};
        int[] leftPosit = {3, 0};
        int[] rightPosit = {3, 2};

        for (int number : numbers) {
            int[] posit = posits[number];
            String choice = pad[posit[0]][posit[1]];
            if (choice.isEmpty()){
                int numA = dfs(leftPosit, posit);
                int numB = dfs(rightPosit, posit);
                if (numA == numB) choice = mainHand(hand);
                else if(numA > numB) choice = "R";
                else choice = "L";
            }
            if (choice.equals("L")) leftPosit = posit;
            else rightPosit = posit;
            sb.append(choice);
        }
        return sb.toString();
    }
    
    public String mainHand(String hand){
        Map<String, String> mainHand = new HashMap<>();
        mainHand.put("right", "R");
        mainHand.put("left", "L");

        return mainHand.get(hand);
    }

    public int dfs(int[] position, int[] goal) {
        check = new int[4][3];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(position[0]);
        queue.add(position[1]);

        while (!queue.isEmpty()) {
            Integer x = queue.remove();
            Integer y = queue.remove();
            if (goal[0] == x && goal[1] == y)
                return check[x][y];

            for (int i = 0; i < 4; i++) {
                int zx = x + dx[i];
                int zy = y + dy[i];
                if (zx >= 0 && zx <= 3 && zy >= 0 && zy <= 2 && check[zx][zy] == 0) {
                    queue.add(zx);
                    queue.add(zy);
                    check[zx][zy] = check[x][y] + 1;
                }
            }
        }
        return check[goal[0]][goal[1]];
    }
}