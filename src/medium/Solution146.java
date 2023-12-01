package medium;

// 146. LRU Cache

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    static class LRUCache {

        private int cap;
        private Map<Integer, Node> map;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            cap = capacity;
            map = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            Node curr = map.get(key);
            Node left = curr.prev;
            Node right = curr.next;
            left.next = right;
            right.prev = left;
            head.next.prev = curr;
            curr.next = head.next;
            head.next = curr;
            curr.prev = head;
            return curr.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node curr = map.get(key);
                curr.val = value;
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;

                curr.prev = head;
                curr.next = head.next;
                head.next.prev = curr;
                head.next = curr;

            } else {
                if (this.cap == map.size()) {
                    Node last = tail.prev;
                    map.remove(last.key);
                    tail.prev = last.prev;
                    last.prev.next = tail;
                    last.next = null;
                    last.prev = null;
                }

                Node curr = new Node(key, value);
                map.put(key, curr);
                curr.prev = head;
                curr.next = head.next;
                head.next.prev = curr;
                head.next = curr;
            }

        }
    }
}
