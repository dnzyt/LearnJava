package medium;

// 61. Rotate List

import util.ListNode;

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        k %= n;
        if (k == 0)
            return head;
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1.next = head;
        p2.next = head;
        while (k-- > 0) {
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = p1.next;
        p2.next = head;
        p1.next = null;
        return dummy.next;
    }
}
