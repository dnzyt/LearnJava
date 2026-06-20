package medium;

// 2095. Delete the Middle Node of a Linked List

import util.ListNode;

public class Solution2095 {
    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null)
            return null;
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);
        slow = head;
        fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
