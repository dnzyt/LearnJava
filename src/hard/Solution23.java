package hard;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode l : lists) {
            if (l != null)
                pq.offer(l);
        }
        ListNode head = new ListNode();
        ListNode curr = head;
        while (!pq.isEmpty()) {
            ListNode x = pq.poll();
            curr.next = x;
            curr = x;
            if (x.next != null)
                pq.offer(x.next);
        }
        return head.next;
    }
}
