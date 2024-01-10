package medium;

public class Solution708 {
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node t = new Node(insertVal);
        if (head == null) {
            t.next = t;
            return t;
        }

        Node curr = head;
        while (curr.next != head) {
            if (curr.val <= insertVal && insertVal <= curr.next.val) {
                t.next = curr.next;
                curr.next = t;
                return head;
            } else if (curr.val > curr.next.val) {
                if (insertVal >= curr.val || insertVal <=curr.next.val) {
                    t.next = curr.next;
                    curr.next = t;
                    return head;
                }
            }
            curr = curr.next;
        }

        t.next = curr.next;
        curr.next = t;
        return head;

    }

}


