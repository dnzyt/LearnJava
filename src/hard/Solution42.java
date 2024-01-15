package hard;

// 42. Trapping Rain Water

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

}
