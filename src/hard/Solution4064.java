package hard;

// 4064. Longest Subarray Divisible by K with At Most One Negation II

import java.awt.image.renderable.RenderableImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4064 {
    public int longestSubarray(int[] nums, int k) {
        List<Integer>[] pos = new List[k];
        Arrays.setAll(pos, i -> new ArrayList<>());
        int[] firstPos = new int[k];
        int[] lastPos = new int[k];
        Arrays.fill(firstPos, -1);
        Arrays.fill(lastPos, -1);
        firstPos[0] = 0;
        lastPos[0] = 0;
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = ((sum + nums[i]) % k + k) % k;
            pos[(nums[i] * 2 % k + k) % k].add(i);
            int r = i + 1;
            if (firstPos[sum] < 0)
                firstPos[sum] = r;
            lastPos[sum] = r;
            ans = Math.max(ans, lastPos[sum] - firstPos[sum]);
        }

        for (int sl = 0; sl < k; sl++) {
            int l = firstPos[sl];
            if (l < 0)
                continue;
            for (int sr = 0; sr < k; sr++) {
                int r = lastPos[sr];
                if (r - l <= ans)
                    continue;
                int s = (sr - sl + k) % k;
                int idx = lowerBound(pos[s], l);
                if (idx < pos[s].size() && pos[s].get(idx) < r)
                    ans = r - l;
            }
        }
        return ans;
    }

    private int lowerBound(List<Integer> nums, int target) {
        int l = -1, r = nums.size();
        while (l + 1 < r) {
            int mid = (l + r) >>> 1;
            if (nums.get(mid) >= target)
                r = mid;
            else
                l = mid;
        }
        return r;
    }
}
