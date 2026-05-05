package hard;

// 354. Russian Doll Envelopes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution354 {

    // 先按照宽度从小到大排，宽短一样的时候高度按照从大到小排
    // 取最长递增子序列
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        List<Integer> g = new ArrayList<>();
        for (int[] p : envelopes) {
            int idx = lowerBound(g, p[1]);
            if (idx == g.size())
                g.add(p[1]);
            else
                g.set(idx, p[1]);
        }
        return g.size();
    }

    private int lowerBound(List<Integer> nums, int target) {
        int l = -1, r = nums.size();
        while (l + 1 < r) {
            int mid = (l + r) >>> 1;
            if (nums.get(mid) >= target) {
                l = mid;
            } else
                r = mid;
        }
        return r;
    }

}
