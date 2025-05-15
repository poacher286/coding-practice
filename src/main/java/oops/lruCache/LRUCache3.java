package oops.lruCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache3 {
    private final int capacity;
    private final Map<Integer, Integer> map;

    public LRUCache3(int capacity){
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.remove(key);
        map.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.remove(key);
        } else if (capacity == map.size()) {
            int first = map.entrySet().iterator().next().getKey();
            map.remove(first);
        } map.put(key, value);
    }
}
