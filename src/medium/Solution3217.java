package medium;

// 3217. Delete Nodes From Linked List Present in Array

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr.val)) {
                p0.next = curr.next;
            } else {
                p0 = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
