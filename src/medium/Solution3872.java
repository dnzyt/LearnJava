package medium;

// 3872. Longest Arithmetic Sequence After Changing At Most One Element

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution3872 {
    public int longestArithmetic(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return n;
        List<int[]> prefix = new ArrayList<>();
        int ans = 1;
        prefix.add(new int[]{0, 1}); // 公差,长度
        for (int i = 1; i < n; i++) {
            int preDiff = prefix.getLast()[0], preLength = prefix.getLast()[1];
            if (nums[i] - nums[i - 1] == preDiff) {
                prefix.add(new int[]{preDiff, preLength + 1});
            } else {
                prefix.add(new int[]{nums[i] - nums[i - 1], 2});
            }
            ans = Math.max(ans, prefix.getLast()[1]);
        }

        List<int[]> suffix = new ArrayList<>();
        suffix.add(new int[]{0, 1});
        for (int i = n - 2; i >= 0; i--) {
            int preDiff = suffix.getLast()[0], preLength = suffix.getLast()[1];
            if (nums[i] - nums[i + 1] == preDiff) {
                suffix.add(new int[]{preDiff, preLength + 1});
            } else {
                suffix.add(new int[]{nums[i] - nums[i + 1], 2});
            }
            ans = Math.max(ans, suffix.getLast()[1]);
        }
        Collections.reverse(suffix);
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, Math.max(prefix.get(i)[1], suffix.get(i)[1]) + 1);
            if ((nums[i + 1] - nums[i - 1]) % 2 != 0)
                continue;
            int[] a = prefix.get(i - 1);
            int[] b = suffix.get(i + 1);
            int diff = (nums[i + 1] - nums[i - 1]) / 2;
            if (diff == a[0] && diff == -b[0])
                ans = Math.max(ans, a[1] + b[1] + 1);
            else if (diff == a[0])
                ans = Math.max(ans, a[1] + 2);
            else if (diff == -b[0])
                ans = Math.max(ans, 2 + b[1]);
        }
        return ans;
    }
}
