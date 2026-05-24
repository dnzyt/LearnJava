package hard;

// 3934. Smallest Unique Subarray

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3934 {

    private static final int BASE = 499;
    private static final int MAXN = 100000;
    private static final long[] pow = new long[MAXN + 1];
    private static boolean initialized;

    public Solution3934() {
        if (initialized) {
            return;
        }
        initialized = true;
        pow[0] = 1;
        for (int i = 1; i <= MAXN; i++)
            pow[i] = pow[i - 1] * BASE;
    }

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long[] hash = new long[n];
        hash[0] = nums[0];
        for (int i = 1; i < n; i++)
            hash[i] = hash[i - 1] * BASE + nums[i];
        int l = 1, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (check(hash, mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    private boolean check(long[] hash, int len) {
        Map<Long, Integer> cnt = new HashMap<>();
        Set<Long> ans = new HashSet<>();
        for (int i = 0; i + len - 1 < hash.length; i++) {
            int j = i + len - 1;
            long t = hash[j];
            if (i != 0)
                t -= hash[i - 1] * pow[len];
            cnt.merge(t, 1, Integer::sum);
            if (cnt.get(t) == 1)
                ans.add(t);
            else if (cnt.get(t) == 2)
                ans.remove(t);
        }

        return ans.size() > 0;
    }
}
