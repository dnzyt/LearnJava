package medium;

// 3660. Jump Game IX

import java.util.*;


// 有O(n)的解法, DP
public class Solution3660 {
    // 主要是寻找每个i位置往右跳，最远能跳到哪
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        // 只跳一次，从i往右最远能到哪里
        int[] rightMost = new int[n];
        List<int[]> last = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int pos = lowerBound(last, new int[]{nums[i], i});
            if (pos == last.size()) {
                rightMost[i] = i;
                last.add(new int[]{nums[i], i});
            } else {
                rightMost[i] = last.get(pos)[1];
            }
        }

        int[] preMax = new int[n];
        int[] preMaxIdx = new int[n];
        int mx = -1;
        int mxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= mx) {
                mxIdx = i;
                mx = nums[i];
            }
            preMax[i] = mx;
            preMaxIdx[i] = mxIdx;
        }
        // 不限次数，从i往右最远能到哪里
        for (int i = n - 1; i >= 0; i--) {
            rightMost[i] = rightMost[rightMost[preMaxIdx[i]]];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = preMax[rightMost[i]];
        }
        return ans;
    }

    private int lowerBound(List<int[]> d, int[] t) {
        int l = -1, r = d.size();
        while (l + 1 < r) {
            int mid = (l + r) >>> 1;
            if (d.get(mid)[0] < t[0])
                r = mid;
            else
                l = mid;
        }
        return r;
    }
}
