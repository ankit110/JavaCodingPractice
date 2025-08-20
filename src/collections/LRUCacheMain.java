package collections;

public class LRUCacheMain {

    public static void main(String[] args) {


        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache);
        cache.get(1); // Accessing 1 makes it most recently used
        System.out.println(cache);
        cache.put(4, "D"); // Evicts key 2 (least recently used)

        // How LinkedHashMap with Access Order Works
        // When you create a LinkedHashMap like this:
        // new LinkedHashMap<>(capacity, 0.75f, true);

//        The third parameter true enables access-order instead of the default insertion-order.

//        The third parameter true enables access-order instead of the default insertion-order.
//
//      🔁 What Access-Order Means:
//        Every time you access an entry (via get() or put()), that entry is moved to the end of the internal linked list.
//        This makes it the most recently used.

//        LRUCache<Integer, String> cache = new LRUCache<>(3);
//        cache.put(1, "A"); // {1=A}
//        cache.put(2, "B"); // {1=A, 2=B}
//        cache.put(3, "C"); // {1=A, 2=B, 3=C}
//        cache.get(1); // Access key 1
//        This moves key 1 to the end of the internal order:
//
//        Before access: {1=A, 2=B, 3=C}
//        After access:  {2=B, 3=C, 1=A}

//        So now, if you do:
//      cache.put(4, "D");

//        It will evict the least recently used, which is now 2, and the cache becomes:
//
//        {3=C, 1=A, 4=D}
//        This behavior ensures that:
//
//        Frequently accessed items stay in the cache.
//                Rarely accessed items get evicted first.


    }

}


