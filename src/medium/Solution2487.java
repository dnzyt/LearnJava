package medium;

// 2487. Remove Nodes From Linked List

import util.ListNode;

public class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode curr = head;
        int maxx = 0;
        while (curr != null) {
            maxx = Math.max(maxx, curr.val);
            if (curr.val < maxx) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
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

    // 递归
    public ListNode removeNodes2(ListNode head) {
        if (head.next == null) return head;
        ListNode node = removeNodes(head.next);
        if (head.val < node.val) {
            return node;
        }
        head.next = node;
        return head;
    }
}
