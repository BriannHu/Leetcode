// MEDIUM - https://leetcode.com/problems/lru-cache/

import java.util.HashMap;

public class LRUCache {

    class DLLNode { // doubly linked list node
        int key;
        int value;
        DLLNode prev;
        DLLNode next;
    }

    // add right after head (pseudo null)
    private void addNode(DLLNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // remove existing node
    private void removeNode(DLLNode node) {
        DLLNode prevNode = node.prev;
        DLLNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // move node to right after head
    private void moveToHead(DLLNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // retrieve and remove tail
    private DLLNode popTail() {
        DLLNode res = tail.prev;
        this.removeNode(res);
        return res;
    }

    int capacity;
    int count;
    HashMap<Integer, DLLNode> cache = new HashMap<>();
    DLLNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        head = new DLLNode();
        head.prev = null;

        tail = new DLLNode();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLLNode node = cache.get(key);

        if (node == null) {
            return -1;
        }

        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLLNode node = cache.get(key);

        if (node == null) {
            DLLNode newNode = new DLLNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);
            count++;

            if (count > capacity) {
                DLLNode res = this.popTail();
                this.cache.remove(res.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}