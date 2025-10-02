package medium;

// 3355. Zero Array Transformation I

public class Solution3355 {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];
            diff[left] += 1;
            diff[right + 1] -= 1;
        }
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += diff[i];
            if (s < nums[i])
                return false;
        }
        return true;
    }
}
