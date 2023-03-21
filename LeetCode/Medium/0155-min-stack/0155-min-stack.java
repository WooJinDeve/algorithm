import java.util.*;

class MinStack {
    
    List<Integer> list;
    PriorityQueue<Integer> pqueue;
    
    public MinStack() {
        list = new LinkedList<>();
        pqueue = new PriorityQueue<>();
    }

    public void push(int val) {
        list.add(0, val);
        pqueue.offer(val);
    }

    public void pop() {
        Integer n = list.get(0);
        list.remove(0);
        pqueue.remove(n);
    }

    public int top() {
        return list.get(0);
    }

    public int getMin() {
        return pqueue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */