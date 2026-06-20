package medium;

// 2326. Spiral Matrix IV

import util.ListNode;

import java.util.Arrays;

public class Solution2326 {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m;
    private int n;

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        this.m = m;
        this.n = n;
        int[][] ans = new int[m][n];
        for (int[] row : ans)
            Arrays.fill(row, -1);
        ListNode curr = head;
        int x = 0, y = 0;
        int d = 0;
        while (curr != null) {
            ans[x][y] = curr.val;
            curr = curr.next;
            int dx = x + DIRS[d][0], dy = y + DIRS[d][1];
            if (!isValid(dx, dy) || ans[dx][dy] != -1) {
                d = (d + 1) % 4;
                dx = x + DIRS[d][0];
                dy = y + DIRS[d][1];
            }
            x = dx;
            y = dy;
        }
        return ans;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
