import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int i = sc.nextInt(); i>0; i--){
            Deque<Integer> deque = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;
            int n = sc.nextInt();
            int temp = sc.nextInt();
            for(int j = 0; j<n; j++) {
                int dummy = sc.nextInt();
                if(temp == j)
                    deque.add(0);
                else
                    deque.add(dummy);
                list.add(dummy);
            }
            
            int A = list.get(temp);
            Collections.sort(list,Comparator.reverseOrder());

            while (true){
                Integer item = deque.poll();
                if(item == 0 && A == list.get(0)){
                    count++;
                    break;
                }else if(item == list.get(0)){
                    list.remove(0);
                    count++;
                }else {
                    deque.offer(item);
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}