package easy;

// 83. Remove Duplicates from Sorted List

import util.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p0 = head;
        while (p0 != null) {
            while (p0.next != null && p0.val == p0.next.val) {
                p0.next = p0.next.next;
            }
            p0 = p0.next;
        }

        return head;
    }
}
