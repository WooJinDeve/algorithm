import java.util.*;

class Solution {
    
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int[][] map; 
        
    public int[] solution(String[] park, String[] routes) {
        Map<String, Integer> root = new HashMap<>();
        root.put("N", 0);
        root.put("S", 1);
        root.put("W", 2);
        root.put("E", 3);
        
        int s1, s2, e1, e2, n, m;
        s1 = s2 = 0;
        n = park.length;
        m = park[0].length();
        
        map = new int[n][m];
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    s1 = i;
                    s2 = j;
                }
                if(park[i].charAt(j) == 'X')
                    map[i][j] = -1;
            }
        }
        
        
        for(String route : routes){
            int idx = root.get(route.split(" ")[0]);
            int dir = Integer.parseInt(route.split(" ")[1]);
            
            int x = s1;
            int y = s2; 
            boolean ok = true; 
            for(int i = 0; i < dir; i++){
                int x1 = x + dx[idx];
                int y1 = y + dy[idx];
                
                if(x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && map[x1][y1] != -1){
                    x += dx[idx];
                    y += dy[idx];
                    continue;
                }
                ok = false;
            }
            
            s1 = ok ? x : s1;
            s2 = ok ? y : s2;
        }
        
        int[] answer = { s1, s2 };
        return answer;
    }
}