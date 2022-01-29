package stack_queue.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LRUCache2
 * @description: 同LRUCache1
 * 使用语言所含的双向链表
 * @author: mzy
 * @create: 2022-01-29 18:17
 * @Version 1.0
 **/
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    // 缓存的容量
    private int capacity;
    public LRUCache2(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}
