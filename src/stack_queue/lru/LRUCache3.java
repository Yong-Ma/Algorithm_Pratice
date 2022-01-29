package stack_queue.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LRUCache3
 * @description: 同LRUCache1
 * 用双向链表+HashMap实现，双向链表由自己实现
 * @author: mzy
 * @create: 2022-01-29 18:30
 * @Version 1.0
 **/
public class LRUCache3 {

    private class DListNode {
        private int key;
        private int value;
        private DListNode prev;
        private DListNode next;
        public DListNode() {}
        public DListNode(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }

    private Map<Integer, DListNode> cache =  new HashMap<>();
    private int size;
    private int capacity;
    private DListNode head;
    private DListNode tail;

    public LRUCache3(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DListNode node = cache.get(key);
        if (node == null) {
            DListNode newNode = new DListNode(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);
            ++size;
            if (size > capacity) {
                DListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    // 删除该节点
    private void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //
    private void addNodeToHead(DListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 将节点移动到头节点的下一个节点
    private void moveToHead(DListNode node) {
        removeNode(node);
        addNodeToHead(node);
    }
    // 删除尾部节点，就是最久未使用的节点
    private DListNode removeTail() {
        DListNode oldNode = tail.prev;
        removeNode(oldNode);
        return oldNode;
    }
}
