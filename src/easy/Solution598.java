package easy;

// 598. Range Addition II

import util.DiffArray2D;

public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0)
            return m * n;
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        return minRow * minCol;
    }
}
