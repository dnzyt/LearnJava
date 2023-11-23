package medium;

import java.util.Stack;

// 2282. Number of People That Can Be Seen in a Grid

public class Solution2282 {
    public int[][] seePeople(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] res = new int[m][n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            stack.clear();
            for (int j = n - 1; j >= 0; j--) {
                int count = 0;
                while (!stack.empty() && heights[i][j] > heights[i][stack.peek()]) {
                    count += 1;
                    stack.pop();
                }
                if (!stack.empty()) {
                    count += 1;
                    if (heights[i][stack.peek()] == heights[i][j])
                        stack.pop();
                }
                stack.add(j);
                res[i][j] = count;
            }
        }

        for (int j = 0; j < n; j++) {
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                int count = 0;
                while (!stack.empty() && heights[i][j] > heights[stack.peek()][j]) {
                    count += 1;
                    stack.pop();
                }
                if (!stack.empty()) {
                    count += 1;
                    if (heights[stack.peek()][j] == heights[i][j])
                        stack.pop();
                }
                stack.add(i);
                res[i][j] += count;
            }
        }

        return res;
    }
}
