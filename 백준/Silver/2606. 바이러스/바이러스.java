import java.util.Scanner;

public class Main {
    static int N_com, N_conn;
    static int map[][];
    static int cnt;
    static int visited[];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N_com = scan.nextInt();
        N_conn = scan.nextInt();

        map = new int[N_com+1][N_com+1];
        visited = new int[N_com+1];

        for(int i=0;i<N_conn;i++)
        {
            int a = scan.nextInt();
            int b = scan.nextInt();
            map[a][b] = map[b][a] = 1;
        }

        dfs(1);
        System.out.println(cnt);
    }


    static void dfs(int start)
    {
        visited[start] = 1;

        for(int i=1;i<N_com+1;i++)
        {
            if(map[start][i] == 1 && visited[i] == 0)
            {
                dfs(i);
                cnt++;
            }
        }
    }
}