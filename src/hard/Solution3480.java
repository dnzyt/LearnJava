package hard;

// 3480. Maximize Subarrays After Removing One Conflicting Pair

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3480 {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] g = new List[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] p : conflictingPairs) {
            g[Math.min(p[0], p[1])].add(Math.max(p[0], p[1]));
        }
        long ans = 0l;
        long[] extra = new long[n + 1];
        long mxExtra = 0l;
        List<Integer> b = new ArrayList<>();
        b.add(n + 1);
        b.add(n + 1);
        for (int i = n; i > 0; i--) {
            b.addAll(g[i]);
            Collections.sort(b);
            b.subList(2, b.size()).clear();
            ans += b.get(0) - i;
            extra[b.get(0)] += b.get(1) - b.get(0);
            mxExtra = Math.max(mxExtra, extra[b.get(0)]);
        }

        return ans + mxExtra;
    }
}
