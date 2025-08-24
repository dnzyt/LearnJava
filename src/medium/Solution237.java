package medium;

// 237. Delete Node in a Linked List

import util.ListNode;

public class Solution237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
