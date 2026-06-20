package medium;

// 2130. Maximum Twin Sum of a Linked List

import util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2130 {
    public int pairSum(ListNode head) {
        ListNode dummy = head;
        Deque<Integer> st = new ArrayDeque<>();
        int n = 0;
        while (dummy != null) {
            n++;
            st.push(dummy.val);
            dummy = dummy.next;
        }
        int ans = 0;
        n /= 2;
        dummy = head;
        while (n-- > 0) {
            ans = Math.max(ans, dummy.val + st.pop());
            dummy = dummy.next;
        }
        return ans;
    }
}
