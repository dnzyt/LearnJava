package medium;

// 445. Add Two Numbers II

import util.ListNode;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p0 = dummy;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            ListNode temp = new ListNode(val % 10);
            carry = val / 10;
            p0.next = temp;
            p0 = temp;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + carry;
            ListNode temp = new ListNode(val % 10);
            carry = val / 10;
            p0.next = temp;
            p0 = temp;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + carry;
            ListNode temp = new ListNode(val % 10);
            carry = val / 10;
            p0.next = temp;
            p0 = temp;
            l2 = l2.next;
        }
        if (carry != 0) {
            p0.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
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
