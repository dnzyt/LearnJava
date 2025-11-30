package medium;

// 3761. Minimum Absolute Distance Between Mirror Pairs

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3761 {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int r = reverse(nums[i]);
            if (map.containsKey(r))
                ans = Math.min(ans, i - map.get(r));
            map.put(nums[i], i);
        }
        return ans;
    }

    private int reverse(int num) {
        List<Integer> a = new ArrayList<>();
        while (num != 0) {
            int d = num % 10;
            a.add(d);
            num /= 10;
        }
        int x = 1;
        int ans = 0;
        for (int i = a.size() - 1; i >= 0; i--) {
            ans += a.get(i) * x;
            x *= 10;
        }
        return ans;
    }
}
