// MEDIUM - https://leetcode.com/problems/lru-cache/

// simpler implementation from https://www.reddit.com/r/cscareerquestions/comments/4ogkpt/level_of_complexity_when_asked_to_code_a_lru_cache/

import java.util.HashMap;

class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(Math.min(Integer.MAX_VALUE / 2, capacity) * 2);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node result = cache.get(key);
        if (result == null)
            return -1;

        removeNode(result);
        addNode(result);

        return result.val;
    }

    public void set(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            removeNode(node);
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.val = value;
        addNode(newNode);

        if (cache.size() > capacity) {
            removeNode(tail.prev);
        }
    }

    private void removeNode(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(Node node) {
        cache.put(node.key, node);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    static class Node {
        int key, val;
        Node prev, next;
    }
}