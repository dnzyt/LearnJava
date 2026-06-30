package easy;

// 2367. Number of Arithmetic Triplets

public class Solution2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int ans = 0;
        int i = 0, j = 1;
        for (int k = 2; k < n; k++) {
            while (nums[j] + diff < nums[k])
                j++;
            if (nums[j] + diff > nums[k])
                continue;
            while (nums[i] + diff + 2 < nums[k])
                i++;
            if (nums[i] + diff * 2 == nums[k])
                ans++;
        }
        return ans;
    }
}
