package hard;

// 42. Trapping Rain Water

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution42 {

    public int trap(int[] height) {
        int n = height.length;
        int lmax = 0, rmax = 0;
        int[] preHighest = new int[n];
        int[] nextHighest = new int[n];

        for (int i = 0; i < n; i++) {
            preHighest[i] = lmax;
            lmax = Math.max(lmax, height[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            nextHighest[i] = rmax;
            rmax = Math.max(rmax, height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int minHight = Math.min(preHighest[i], nextHighest[i]);
            if (height[i] >= minHight)
                continue;
            res += (minHight - height[i]);
        }
        return res;
    }

    public int trap2(int[] height) {
        // 相向双指针
        // 更矮的那一边的储水量是可以确定的
        int res = 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int preMax = 0;
        int sufMax = 0;
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (preMax < sufMax) {
                res += preMax - height[left];
                left++;
            } else {
                res += sufMax - height[right];
                right--;
            }
        }
        return res;
    }

    // 单调栈
    public int trap3(int[] height) {
        int n = height.length;
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int h = height[i];
            while (!st.isEmpty() && h >= height[st.peek()]) {
                int bottomHeight = height[st.pop()];
                if (st.isEmpty()) break;
                int left = st.peek();
                ans += (Math.min(h, height[left]) - bottomHeight) * (i - left - 1);
            }
            st.push(i);
        }
        return ans;
    }

}
