import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] arr = new ArrayList[n];
        boolean[] node = new boolean[n];
        for (int i = 0; i < n; i++) arr[i] = new ArrayList<>();

        //최상위 마약공급책을 node 배열에 저장
        while (m-- > 0) {
            int x = sc.next().charAt(0) - 'A';
            int y = sc.next().charAt(0) - 'A';
            arr[x].add(y);
            node[y] = true;
        }

        m = sc.nextInt();
        boolean[] check = new boolean[n];
        //check 배열에 경찰의 정보를 저장
        while (m-- > 0) {
            int x = sc.next().charAt(0) - 'A';
            check[x] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        //경찰에게 잡히지 않은 마약공급책을 저장한다.
        for (int i = 0; i < n; i++) {
            if (!node[i] && !check[i]) queue.add(i);
        }

        int ans = 0;
        while (!queue.isEmpty()){
            int x = queue.remove();
            //마약공급책의 자식 노드를 순회하면서 저장한다.
            //중복을 방지하기 위해 방문 여부를 체크한다.
            for (Integer i : arr[x]) {
                if (!check[i]){
                    check[i] = true;
                    queue.add(i);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}

