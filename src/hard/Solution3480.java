package hard;

// 3480. Maximize Subarrays After Removing One Conflicting Pair

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution3480 {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] groups = new ArrayList[n + 1];
        Arrays.setAll(groups, i -> new ArrayList<>());
        for (int[] p : conflictingPairs) {
            int a = p[0];
            int b = p[1];
            groups[Math.min(a, b)].add(Math.max(a, b));
        }
        List<Integer> b = new ArrayList<>(List.of(n + 1, n + 1));
        long ans = 0;
        long[] extra = new long[n + 2];
        long mx = -1;
        for (int i = n; i > 0; i--) {
            b.addAll(groups[i]);
            Collections.sort(b);
            b.subList(2, b.size()).clear();
            int b0 = b.get(0);
            int b1 = b.get(1);
            ans += b0 - i;
            extra[b0] += b1 - b0;
            mx = Math.max(mx, extra[b0]);
        }
        return ans + mx;
    }
}
