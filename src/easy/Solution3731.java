package easy;

// 3731. Find Missing Elements

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3731 {
    public List<Integer> findMissingElements(int[] nums) {
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            mn = Math.min(mn, num);
            mx = Math.max(mx, num);
            s.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = mn + 1; i < mx; i++) {
            if (!s.contains(i))
                ans.add(i);
        }
        return ans;
    }
}
