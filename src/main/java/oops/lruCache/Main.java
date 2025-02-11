package oops.lruCache;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3); // Create an LRU cache with capacity 3

        // Adding values to the cache
        cache.put(1, 1); // cache: {1=1}
        cache.put(2, 2); // cache: {1=1, 2=2}
        cache.put(3, 3); // cache: {1=1, 2=2, 3=3}

        // Get value of key 2
        System.out.println(cache.get(2)); // returns 2, cache: {1=1, 3=3, 2=2}

        // Adding another value, which will cause eviction of the least recently used key
        cache.put(4, 4); // evicts key 1, cache: {3=3, 2=2, 4=4}

        // Get value of key 1 (should return -1 because it was evicted)
        System.out.println(cache.get(1)); // returns -1

        // Get value of key 3
        System.out.println(cache.get(3)); // returns 3

        // Get value of key 4
        System.out.println(cache.get(4)); // returns 4
    }
}
