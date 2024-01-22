package medium;

// 646. Maximum Length of Pair Chain

import java.util.*;

public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        List<Integer> t = new ArrayList<>();
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        for (int[] p : pairs) {
            int idx = lowerBound(t, p[0]);
            if (idx == t.size())
                t.add(p[1]);
            else
                t.set(idx, Math.min(t.get(idx), p[1]));
        }

        return t.size();
    }

    private int lowerBound(List<Integer> t, int target) {
        int l = 0, r = t.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (t.get(mid) < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
