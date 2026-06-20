package medium;

import java.util.ArrayDeque;
import java.util.Deque;

// 2282. Number of People That Can Be Seen in a Grid

public class Solution2282 {
    public int[][] seePeople(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] ans = new int[m][n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            int[] row = heights[i];
            st.clear();
            for (int j = 0; j < n; j++) {
                boolean hasSame = false;
                while (!st.isEmpty() && row[st.peek()] <= row[j]) {
                    int left = st.pop();
                    ans[i][left] += 1;
                    if (row[left] == row[j])
                        hasSame = true;
                }
                if (!st.isEmpty() && !hasSame) {
                    ans[i][st.peek()] += 1;
                }
                st.push(j);
            }
        }

        for (int j = 0; j < n; j++) {
            st.clear();
            for (int i = 0; i < m; i++) {
                boolean hasSame = false;
                while (!st.isEmpty() && heights[st.peek()][j] <= heights[i][j]) {
                    int top = st.pop();
                    ans[top][j] += 1;
                    if (heights[top][j] == heights[i][j])
                        hasSame = true;
                }
                if (!st.isEmpty() && !hasSame)
                    ans[st.peek()][j] += 1;
                st.push(i);
            }
        }
        return ans;
    }
}
