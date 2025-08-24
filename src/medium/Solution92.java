package medium;

// 92. Reverse Linked List II

import util.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode curr = p0.next;
        for (int i = left; i <= right; i++) {
            ListNode nxt = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nxt;
        }
        p0.next.next = curr;
        p0.next = pre;
        return dummy.next;
    }

}
