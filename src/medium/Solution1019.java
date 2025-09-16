package medium;

// 1019. Next Greater Node In Linked List

import util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        int cnt = 0;
        ListNode curr = head;
        while (curr != null) {
            cnt++;
            curr = curr.next;
        }
        int n = cnt;
        Deque<Integer> st = new ArrayDeque<>();

        int[] ans = new int[n];
        int[] nums = new int[n];
        curr = head;
        cnt = 0;
        while (curr != null) {
            nums[cnt] = curr.val;
            while (!st.isEmpty() && curr.val > nums[st.peek()]) {
                int idx = st.pop();
                ans[idx] = curr.val;
            }
            st.push(cnt);
            cnt++;
            curr = curr.next;
        }

        return ans;
    }

    // 递归解法
    private int[] ans;
    private Deque<Integer> st = new ArrayDeque<>();

    public int[] nextLargerNodes2(ListNode head) {
        f(head, 0);
        return ans;
    }

    private void f(ListNode node, int i) {
        if (node == null) {
            ans = new int[i];
            return;
        }
        f(node.next, i + 1);
        while (!st.isEmpty() && node.val >= st.peek()) {
            st.pop();
        }
        if (!st.isEmpty())
            ans[i] = st.peek();
        st.push(node.val);
    }
}
