package hard;

// 3920. Maximize Fixed Points After Deletions

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution3920 {
    public int maxFixedPoints(int[] nums) {
        List<int[]> s = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - nums[i] < 0)
                continue;
            s.add(new int[]{nums[i], i - nums[i]});
        }
        Collections.sort(s, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        List<Integer> g = new ArrayList<>();
        for (int[] p : s) {
            int idx = upperBound(g, p[1]);
            if (idx == g.size())
                g.add(p[1]);
            else
                g.set(idx, p[1]);
        }
        return g.size();
    }

    private int upperBound(List<Integer> arr, int target) {
        int l = -1, r = arr.size();
        while (l + 1 < r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }

}
