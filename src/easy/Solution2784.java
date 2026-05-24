package easy;

// 2784. Check if Array is Good

public class Solution2784 {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] cnt = new int[n + 1];
        for (int num : nums) {
            if (num > n || (num == n && cnt[num] > 1) || (num < 0 && cnt[num] > 0))
                return false;
            cnt[num]++;
        }
        return true;
    }
}
