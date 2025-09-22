package medium;

// 624. Maximum Distance in Arrays

import java.util.List;

public class Solution624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = Integer.MIN_VALUE / 2;
        int mx = Integer.MIN_VALUE / 2;
        int mn = Integer.MAX_VALUE / 2;
        for (List<Integer> a : arrays) {
            ans = Math.max(ans, Math.max(mx - a.get(0), a.get(a.size() - 1) - mn));
            mx = Math.max(mx, a.get(a.size() - 1));
            mn = Math.min(mn, a.get(0));
        }
        return ans;
    }
}
