package hard;

// 410. Split Array Largest Sum

public class Solution410 {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (f(nums, mid) <= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int f(int[] nums, long aim) {
        int res = 0;
        int curr = 0;
        for (int num : nums) {
            if (num > aim)
                return Integer.MAX_VALUE;
            if (curr + num > aim) {
                res += 1;
                curr = num;
                continue;
            }
            curr += num;
        }
        return res + 1;
    }
}
