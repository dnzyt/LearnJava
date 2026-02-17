package medium;

// 3592. Inverse Coin Change

import java.util.ArrayList;
import java.util.List;

public class Solution3592 {
    // 完全背包
    public List<Integer> findCoins(int[] numWays) {
        int mx = 0;
        for (int w : numWays)
            mx = Math.max(mx, w);
        int n = numWays.length;
        int[] f = new int[n + 1];
        f[0] = 1;
        List<Integer> ans = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            int x = numWays[j - 1];
            if (x == f[j])
                continue;
            if (x - 1 != f[j])
                return List.of();

            ans.add(j);
            for (int k = j; k <= n; k++) {
                f[k] += f[k - j];
                if (f[k] > mx)
                    return List.of();
            }

        }
        return ans;
    }
}
