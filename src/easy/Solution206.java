package easy;

// 206. Reverse Linked List

import util.ListNode;

public class Solution206 {


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nxt;
        }
        return pre;
    }
}
