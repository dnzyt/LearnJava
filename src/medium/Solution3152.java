package medium;

// 3152. Special Array II

public class Solution3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] p = new int[n];
        for (int i = 0; i < n - 1; i++) {
            p[i] = nums[i] % 2 == nums[i + 1] % 2 ? 0 : 1;
        }
        p[n - 1] = 1;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + p[i];
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = s[right] - s[left] == right - left;
        }
        return ans;
    }
}
