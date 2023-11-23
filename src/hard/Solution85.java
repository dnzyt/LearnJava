package hard;

// 85. Maximal Rectangle

import java.util.Arrays;
import java.util.Stack;

// 85. Maximal Rectangle

public class Solution85 {
    // 84题的变形，每层地板套用一次84题
    public int maximalRectangle(char[][] matrix) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] h = new int[n];
        int[] preSmaller = new int[n];
        int[] nextSmaller = new int[n];
        for (int i = 0; i < m; i++) {
            stack.clear();
            Arrays.fill(preSmaller, -1);
            Arrays.fill(nextSmaller, n);
            for (int j = 0; j < n; j++)
                h[j] = (matrix[i][j] == '0' ? 0 : (h[j] + 1));
            for (int j = 0; j < n; j++) {
                while (!stack.empty() && h[j] <= h[stack.peek()]) {
                    nextSmaller[stack.pop()] = j;
                }
                if (!stack.empty()) {
                    preSmaller[j] = stack.peek();
                }
                stack.push(j);
            }
            for (int j = 0; j < n; j++)
                res = Math.max(res, h[j] * (nextSmaller[j] - 1 - preSmaller[j]));
        }
        return res;
    }
}
