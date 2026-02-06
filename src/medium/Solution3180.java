package medium;

// 3180. Maximum Total Reward Using Operations I

import java.util.Arrays;

public class Solution3180 {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        int mx = 0;
        for (int num : rewardValues)
            mx = Math.max(mx, num);
        boolean[] f = new boolean[mx * 2];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            int x = rewardValues[i - 1];
            for (int j = mx * 2 - 1; j > 0; j--) {
                f[j] = f[j] || ((j - x) >= 0 && (j - x) < x ? f[j - x] : false);
            }
        }
        for (int i = mx * 2 - 1; i >= 0; i--)
            if (f[i])
                return i;
        return 0;
    }
}
