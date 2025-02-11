package oops.lruCache;

import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private HashMap<Integer, ListNode> cache;
    private ListNode head, tail;

    // Constructor to initialize LRU Cache with capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new ListNode(-1, -1);  // Dummy head
        tail = new ListNode(-1, -1);  // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Move the node to the front (just after head)
    private void moveToHead(ListNode node) {
        removeNode(node);
        addNode(node);
    }

    // Add node right after the head
    private void addNode(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Remove a node from the linked list
    private void removeNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Remove the least recently used (LRU) node
    private ListNode removeTail() {
        ListNode res = tail.prev;
        removeNode(res);
        return res;
    }

    // Get the value of the key if it exists in the cache
    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1; // Key not found
        } else {
            // Move the accessed node to the front
            moveToHead(node);
            return node.value;
        }
    }

    // Put a key-value pair in the cache
    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            // If the cache is full, remove the least recently used item
            if (cache.size() == capacity) {
                ListNode removed = removeTail();
                cache.remove(removed.key);
            }
            // Create a new node and add it to the cache
            node = new ListNode(key, value);
            cache.put(key, node);
            addNode(node);
        } else {
            // Update the value of the existing node and move it to the front
            node.value = value;
            moveToHead(node);
        }
    }
}
