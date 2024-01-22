package hard;

// 354. Russian Doll Envelopes

import java.util.Arrays;
import java.util.Collections;

public class Solution354 {

    // 先按照宽度从小到大排，宽短一样的时候高度按照从大到小排
    // 取最长递增子序列
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = envelopes[i][1];
        Integer[] res = new Integer[n];
        int[] temp = new int[n];
        Arrays.fill(temp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int idx = lowerBound(temp, nums[i]);
            res[i] = idx + 1;
            temp[idx] = nums[i];
        }

        return Collections.max(Arrays.asList(res));
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

}
