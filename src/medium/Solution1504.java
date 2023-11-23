package medium;

import java.util.Stack;

// 1504. Count Submatrices With All Ones

public class Solution1504 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int res = 0;
        int[] h = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            stack.clear();
            // 计算以当前行为底产生的高度
            for (int j = 0; j < n; j++)
                h[j + 1] = mat[i][j] == 0 ? 0 : h[j + 1] + 1;
            stack.push(0);
            int c = 0;
            for (int j = 0; j < n; j++) {
                while (!stack.empty() && h[j + 1] < h[stack.peek()]) {
                    int p1 = stack.pop();
                    int p2 = stack.peek();
                    c = c - (h[p1] - h[j + 1]) * (p1 - p2);
                }
                c += h[j + 1];
                res += c;
                stack.push(j + 1);
            }

        }
        return res;
    }
}
