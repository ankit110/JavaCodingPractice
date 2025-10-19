package com.interview.collections;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        // true = accessOrder, maintains order based on access
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    // This method is called after every put
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // remove oldest if cache exceeds capacity
    }
}

public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println(cache); // {1=A, 2=B, 3=C}

        // Access key 1 → makes it most recently used
        cache.get(1);
        System.out.println(cache); // {2=B, 3=C, 1=A}

        // Add key 4 → evicts least recently used (key 2)
        cache.put(4, "D");
        System.out.println(cache); // {3=C, 1=A, 4=D}
    }
}
