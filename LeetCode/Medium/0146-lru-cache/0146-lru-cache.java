import java.util.LinkedHashMap;
import java.util.Map.Entry;


class LRUCache {

     private final LinkedHashMap<Integer, Integer> lru;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lru = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer val = lru.get(key);

        if (val == null) return -1;

        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        lru.remove(key);
        lru.put(key, value);

        if (lru.size() > capacity) {
            Entry<Integer, Integer> entry = lru.entrySet().iterator().next();
            lru.remove(entry.getKey());
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */