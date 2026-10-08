package medium;

// 1186. Maximum Subarray Sum with One Deletion

public class Solution1186 {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[][] f = new int[n + 1][2];
        // 0 - 一次都没删除过
        // 1 - 已经删除过一次了
        f[0][0] = f[0][1] = Integer.MIN_VALUE / 2;
        int ans = Integer.MIN_VALUE / 2;
        for (int i = 1; i <= n; i++) { // 以i为结尾的子数组
            f[i][0] = Math.max(f[i - 1][0], 0) + arr[i - 1];
            f[i][1] = Math.max(f[i - 1][1] + arr[i - 1], f[i - 1][0]);
            ans = Math.max(ans, Math.max(f[i][0], f[i][1]));
        }
        return ans;
    }
}
