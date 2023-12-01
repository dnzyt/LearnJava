package hard;

// 42. Trapping Rain Water

import java.util.Stack;

public class Solution42 {

    public int trap(int[] height) {
        int n = height.length;
        Stack<Integer> s = new Stack<>();
        int[] preHighest = new int[n];
        int[] nextHighest = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.empty()) {
                s.push(i);
                continue;
            }
            if (height[s.peek()] > height[i]) {
                Integer idx = s.peek();
                preHighest[i] = height[idx];
            } else {
                s.push(i);
            }
        }
        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (s.empty()) {
                s.push(i);
                continue;
            }
            if (height[s.peek()] > height[i]) {
                Integer idx = s.peek();
                nextHighest[i] = height[idx];
            } else {
                s.push(i);
            }

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
