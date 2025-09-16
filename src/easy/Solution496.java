package easy;

// 496. Next Greater Element I

import java.util.*;

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> st = new ArrayDeque<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = n2 - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums2[i] >= nums2[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                m.put(nums2[i], nums2[st.peek()]);
            }
            st.push(i);
        }
        int[] ans = new int[n1];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n1; i++) {
            if (m.containsKey(nums1[i]))
                ans[i] = m.get(nums1);
        }
        return ans;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n2; i++) {
            while (!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
                m.put(nums2[st.pop()], nums2[i]);
            }
            st.push(i);
        }
        int[] ans = new int[n1];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n1; i++)
            if (m.containsKey(nums1[i]))
                ans[i] = m.get(nums1[i]);
        return ans;

    }
}
