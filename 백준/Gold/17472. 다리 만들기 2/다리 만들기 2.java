import java.util.*;
class Edge {
    int from, to, cost;
    Edge (int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
public class Main {
    static int n, m;
    static int[][] map; // map
    static int[][] group; // 섬의 번호 (1~groups)
    static int groups = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Edge> edges = new ArrayList<>();
    static int ans = -1;
    static int[][] a;
    static void bfs(int x, int y) {
        groups += 1;
        Queue<Integer> q = new LinkedList<>();
        group[x][y] = groups;
        q.add(x); q.add(y);
        while(!q.isEmpty()) {
            x = q.remove();
            y = q.remove();
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == 1 && group[nx][ny] == 0) {
                        q.add(nx); q.add(ny);
                        group[nx][ny] = groups;
                    }
                }
            }
        }
    }
    static boolean[] check;
    static void dfs(int x) {
        for (int y=1; y<=groups; y++) {
            if (a[x][y] > 0 && check[y] == false) {
                check[y] = true;
                dfs(y);
            }
        }
    }
    static void go(int index, int cnt, int sum) {
        // edges[index] o/x
        if (cnt > groups) return;
        if (ans != -1 && ans < sum) return;
        if (cnt + (edges.size() - index + 1) < groups-1) return;
        if (index == edges.size()) {
            // 모든 섬이 연결되어있나?
            check = new boolean[groups+1];
            check[1] = true;
            dfs(1);
            for (int i=1; i<=groups; i++) {
                if (check[i] == false) return;
            }
            if (ans == -1 || ans > sum) {
                ans = sum;
            }
            return;
        }
        Edge e = edges.get(index);
        a[e.from][e.to] = a[e.to][e.from] = e.cost;
        go(index+1, cnt+1, sum+e.cost);
        a[e.from][e.to] = a[e.to][e.from] = 0;
        go(index+1, cnt, sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        group = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 1 && group[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
        int[][] bridge = new int[groups+1][groups+1];
        // bridge[i][j] > 0 i -> j length
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 0) continue;
                // (i, j) -> ... -> (x, y)
                for (int k=0; k<4; k++) {
                    int length = 0;
                    int x = i+dx[k];
                    int y = j+dy[k];
                    while (0 <= x && x < n && 0 <= y && y < m) {
                        if (map[x][y] == 0) {
                        } else if (group[x][y] == group[i][j]) {
                            break;
                        } else {
                            if (length >= 2) {
                                int g1 = group[i][j];
                                int g2 = group[x][y];
                                if (bridge[g1][g2] == 0 || bridge[g1][g2] > length) {
                                    bridge[g1][g2] = length;
                                    bridge[g2][g1] = length;
                                }
                            }
                            break;
                        }
                        x += dx[k];
                        y += dy[k];
                        length += 1;
                    }
                }
            }
        }
        for (int i=1; i<=groups; i++) {
            for (int j=i+1; j<=groups; j++) {
                if (bridge[i][j] > 0) {
                    edges.add(new Edge(i, j, bridge[i][j]));
                }
            }
        }
        a = new int[groups+1][groups+1];
        go(0, 0, 0);
        System.out.println(ans);
    }
}