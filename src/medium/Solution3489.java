package medium;

// 3489. Zero Array Transformation IV

public class Solution3489 {
    // 对每一个num进行0-1背包
    public int minZeroArray(int[] nums, int[][] queries) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x == 0)
                continue;
            boolean[] f = new boolean[x + 1];
            f[0] = true;
            for (int j = 0; j < queries.length; j++) {
                int l = queries[j][0], r = queries[j][1], v = queries[j][2];
                if (i < l || i > r)
                    continue;
                for (int k = x; k >= v; k--)
                    f[k] |= f[k - v];
                if (f[x]) {
                    res = Math.max(res, j);
                    break;
                }
            }
            if (!f[x])
                return -1;
        }
        return res;
    }
}
