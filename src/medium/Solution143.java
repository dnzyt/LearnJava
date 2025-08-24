package medium;

import util.ListNode;

// 143. Reorder List

public class Solution143 {
    public void reorderList(ListNode head) {
        ListNode mid = middle(head);
        ListNode head2 = reverse(mid);
        // 从两边往中间处理
        while (head2.next != null) {
            ListNode nxt = head.next;
            ListNode nxt2 = head2.next;
            head.next = head2;
            head2.next = nxt;
            head = nxt;
            head2 = nxt2;
        }

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

    private ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
