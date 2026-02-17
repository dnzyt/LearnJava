package hard;

// 2902. Count of Sub-Multisets With Bounded Sum

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2902 {
    private static final int MOD = 1000000007;

    // 多重背包
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        int sum = 0;
        int cnt0 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            sum += num;
            if (num == 0)
                cnt0++;
            else
                map.merge(num, 1, Integer::sum);
        }
        if (l > sum)
            return 0;

        int n = map.size();
        int[] f = new int[r + 1];
        f[0] = cnt0 + 1;
        int s = 0;
        for (int val : map.keySet()) {
            int cnt = map.get(val);
            int[] fCopy = f.clone();
            s = Math.min(s + cnt * val, r);
            for (int j = val; j <= s; j++) {
                fCopy[j] = (fCopy[j] + fCopy[j - val]) % MOD;
                if (j - (cnt + 1) * val >= 0)
                    fCopy[j] = (fCopy[j] - f[j - (cnt + 1) * val] + MOD) % MOD;
            }
            f = fCopy;
        }
        int res = 0;
        for (int i = l; i <= r; i++) {
            res = (res + f[i]) % MOD;
        }
        return res;
    }

}

/*
 *
 * f[i][j] = f[i-1][j] + f[i-1][j-x] + f[i-1][j-2x] + f[i-1][j-3x] + ... + f[i-1][j-cnt*x]
 * f[i][j-x] = f[i-1][j-x] + f[i-1][j-2x] + f[i-1][j-3x] + ... + f[i-1][j-cnt*x] + f[i-1][j-(cnt+1)*x]
 *
 * f[i][j] - f[i][j-x] = f[i-1][j] - f[i-1][j-(cnt+1)*x]
 *
 * f[i][j] = f[i][j-x] + f[i-1][j] - f[i-1][j-(cnt+1)*x]
 *
 * j小于0的时候可以理解为只考虑前i个元素组成的元素和为负数的情况，这种情况的可能数为0
 * */
