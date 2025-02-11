package oops.lruCache;

import java.util.*;

public class LRUCache2 {
    private int capacity;
    //[key : LL(key, val)]
    private Map<Integer, LinkedListNode> cache;
    private Deque<LinkedListNode> lruList;

    private class LinkedListNode{
        int key;
        int value;

        LinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache2(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            //if cache contains key then move node from LL to front
            //remove node from LL
            //add the node to front of LL
            LinkedListNode node = cache.get(key);
            lruList.remove(node);
            lruList.addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {//adding [key : LL(key, val)] to cache
        if (cache.containsKey(key)) {
            //if cache already contains the key
            //remove node from LL
            //update new value to the node
            //add the node to front of LL
            LinkedListNode node = cache.get(key);
            lruList.remove(node);
            node.value = value;
            lruList.addFirst(node);
        }else{
            //if cache doesn't contains key
                //check if the cache size exceeds capacity
                    //remove node from last from LL
                    //remove that entry from cache
                    //create node and add to front of LL
            if (cache.size() >= capacity) {
                LinkedListNode node = lruList.removeLast();
                cache.remove(node.key);
            }
            LinkedListNode node = new LinkedListNode(key, value);
            lruList.addFirst(node);
            cache.put(key, node);
        }
    }


}
