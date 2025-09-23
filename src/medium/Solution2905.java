package medium;

// 2905. Find Indices With Index and Value Difference II

public class Solution2905 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int mx = nums[0], mn = nums[0];
        int x = 0, y = 0;
        for (int i = indexDifference; i < n; i++) {
            if (mx < nums[i - indexDifference]) {
                mx = nums[i - indexDifference];
                x = i - indexDifference;
            }
            if (mn > nums[i - indexDifference]) {
                mn = nums[i - indexDifference];
                y = i - indexDifference;
            }
            if (mx - nums[i] >= valueDifference)
                return new int[] {x, i};
            if (nums[i] - mn >= valueDifference)
                return new int[] {y, i};
        }
        return new int[] {-1, -1};
    }
}
