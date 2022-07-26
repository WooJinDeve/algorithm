import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visite;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visite = new boolean[n][m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int count = 0, maxv = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 1 && visite[i][j] == false){
                    visite[i][j] = true;
                    count++;
                    maxv = Math.max(maxv,bfs(i,j));
                }
            }
        }
        System.out.println(count);
        System.out.println(maxv);
    }

    public static int bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        visite[y][x] = true;
        int size=1;
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for(int d=0; d<4; d++) {
                int nx = px+dx[d];
                int ny = py+dy[d];
                if(nx<0 || ny<0 || nx>m-1 || ny>n-1) continue;
                if(visite[ny][nx]) continue;
                if(map[ny][nx] == 1) {
                    size++;
                    visite[ny][nx] = true;
                    q.add(new int[] {nx,ny});
                }
            }
        }
        return size;
    }
}