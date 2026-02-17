package medium;

// 1981. Minimize the Difference Between Target and Chosen Elements

public class Solution1981 {
    // 分组型背包
    public int minimizeTheDifference(int[][] mat, int target) {
        int sum = 0;
        int n = mat.length, m = mat[0].length;
        int[] rowMax = new int[n];
        for (int i = 0; i < n; i++) {
            int[] row = mat[i];
            for (int num : row)
                rowMax[i] = Math.max(rowMax[i], num);
            sum += rowMax[i];
        }

        if (target >= sum)
            return target - sum;

        int acc = 0;
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            boolean[] fCopy = new boolean[sum + 1];
            int maxJ = Math.min(acc + rowMax[i - 1], sum);
            int[] row = mat[i - 1];
            for (int j = 0; j <= maxJ; j++) {
                for (int k = 0; k < m; k++)
                    if (j - row[k] >= 0)
                        fCopy[j] |= f[j - row[k]];
            }
            f = fCopy;
            acc += rowMax[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= sum; i++)
            if (f[i])
                ans = Math.min(ans, Math.abs(i - target));
        return ans;
    }
}
