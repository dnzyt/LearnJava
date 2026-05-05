package hard;

// 3229. Minimum Operations to Make Array Equal to Target

public class Solution3229 {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            target[i] -= nums[i];
        nums[0] = target[0];
        for (int i = 1; i < n; i++)
            nums[i] = target[i] - target[i - 1];

        long ans = 0l;
        long s = 0;
        // 如果想操作次数最少，那么要尽可能利用前面用过的+1或者-1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans += s >= 0 ? nums[i] : Math.max(nums[i] + s, 0);
            } else {
                ans += s <= 0 ? -nums[i] : -Math.min(nums[i] + s, 0);
            }
            s += nums[i];
        }
        return ans;
    }
}
