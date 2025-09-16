package hard;

// 85. Maximal Rectangle

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution85 {
    // 84题的变形，每层地板套用一次84题
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    heights[j] += 1;
            }
            ans = Math.max(ans, largestRectangleArea(heights));

        }
        return ans;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int h = heights[i];
            while (!st.isEmpty() && h <= heights[st.peek()]) {
                int idx = st.pop();
                r[idx] = i;
            }
            if (!st.isEmpty()) l[i] = st.peek();
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (r[i] - l[i] - 1) * heights[i]);
        }
        return ans;
    }
}
