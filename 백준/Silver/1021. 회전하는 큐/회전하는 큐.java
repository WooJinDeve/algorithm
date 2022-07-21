import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        int[] arr = new int[sc.nextInt()];
        for(int i = 1; i<=n; i++){
            deque.add(i);
            if(i<=arr.length)
                arr[i-1] = sc.nextInt();
        }
        int count = 0;
        int idx = 0;
        while(idx != arr.length){
            if(deque.getFirst() == arr[idx]){
                deque.poll();
                idx++;
            }else {
                Deque<Integer> deque1 = new LinkedList<>(deque);
                Deque<Integer> deque2 = new LinkedList<>(deque);
                int count1 = 0;
                int count2 = 0;
                while (deque1.getFirst() != arr[idx]){
                    Integer dummy = deque1.poll();
                    deque1.offer(dummy);
                    count1++;
                }
                while (deque2.getFirst() != arr[idx]){
                    Integer dummy = deque2.pollLast();
                    deque2.offerFirst(dummy);
                    count2++;
                }
                if(count1 > count2){
                    count += count2;
                    deque = deque2;
                }else{
                    count += count1;
                    deque = deque1;
                }
            }
        }
        System.out.println(count);
    }
}