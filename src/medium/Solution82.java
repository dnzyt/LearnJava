package medium;

// 82. Remove Duplicates from Sorted List II

import util.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            int val = curr.next.val;
            if (curr.next.next.val != val) {
                curr = curr.next;
            } else {
                while (curr.next != null && curr.next.val == val) {
                    curr.next = curr.next.next;
                }
            }
        }
        return dummy.next;
    }
}
