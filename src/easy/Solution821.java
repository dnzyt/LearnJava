package easy;

// 821. Shortest Distance to a Character

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c)
                positions.add(i);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int idx = lowerBound(positions, i);
            if (idx > 0)
                ans[i] = Math.min(ans[i], i - positions.get(idx - 1));
            if (idx < positions.size())
                ans[i] = Math.min(ans[i], positions.get(idx) - i);
        }

        return ans;
    }

    private int lowerBound(List<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums.get(mid) < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

}
