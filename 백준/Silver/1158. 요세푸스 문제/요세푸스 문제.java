import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int N = in.nextInt();
        int K = in.nextInt();
        for(int i = 1;i  <= N; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while(q.size() > 1) {
            for(int i = 0; i < K - 1; i++) {
                int val = q.poll();
                q.offer(val);
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append('>');
        System.out.println(sb);
    }
}