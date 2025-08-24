package hard;

// 25. Reverse Nodes in k-Group

import util.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n ++;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        curr = head;
        while (n >= k) {
            n -= k;

            for (int i = 0; i < k; i++) {
                ListNode nxt = curr.next;
                curr.next = pre;
                pre = curr;
                curr = nxt;
            }
            ListNode nxt = p0.next;
            p0.next = pre;
            nxt.next = curr;
            p0 = nxt;
        }
        return dummy.next;
    }
}
