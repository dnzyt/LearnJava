package medium;

// 3952. Maximum Total Value of Covered Indices

public class Solution3952 {
    public long maxTotal(int[] nums, String s) {
        char[] chs = s.toCharArray();
        int n = nums.length;
        long ans = 0;
        int i = 0;
        int min = 0;
        while (i < n) {
            if (chs[i] == '1') {
                ans += nums[i];
                min = Math.min(min, nums[i]);
                if (i + 1 == n || chs[i + 1] == '0') {
                    ans -= min;
                }
            } else if (i + 1 < n && chs[i + 1] == '1') {
                min = nums[i];
                ans += nums[i];
            }
            i++;
        }
        return ans;
    }
}
