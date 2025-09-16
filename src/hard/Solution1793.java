package hard;

// 1793. Maximum Score of a Good Subarray

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1793 {
    // 单调站解法
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int h = nums[i];
            while (!st.isEmpty() && h <= nums[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty())
                l[i] = st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            int h = nums[i];
            while (!st.isEmpty() && h <= nums[st.peek()])
                st.pop();
            if (!st.isEmpty())
                r[i] = st.peek();
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (l[i] < k && k < r[i])
                ans = Math.max(ans, nums[i] * (r[i] - l[i] - 1));
        }
        return ans;
    }


    // 双指针
    public int maximumScore2(int[] nums, int k) {
        int n = nums.length;
        int i = k, j = k;
        int ans = nums[k], minH = nums[k];
        for (int t = 0; t < n - 1; t++) {
            if (j == n - 1 || i > 0 && nums[i - 1] > nums[j + 1])
                minH = Math.min(minH, nums[--i]);
            else
                minH = Math.min(minH, nums[++j]);
            ans = Math.max(ans, minH * (j - i + 1));
        }

        return ans;
    }
}
