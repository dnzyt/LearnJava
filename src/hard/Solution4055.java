package hard;

// 4055. Count Shadow Pairs II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution4055 {
    public int shadowPairs(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        List<Integer> p = new ArrayList<>();
        for (int num : nums) p.add(Arrays.binarySearch(sorted, num));
        return solve(p, 0, n - 1);
    }

    private int solve(List<Integer> nums, int l, int r) {
        int n = nums.size();
        if (n <= 1 || l == r)
            return 0;

        int res = 0;
        List<Integer> lowerSt = new ArrayList<>();
        List<Integer> upperSt = new ArrayList<>();

        List<Integer> lower = new ArrayList<>();
        List<Integer> upper = new ArrayList<>();
        int mid = (l + r) >>> 1;
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if (num <= mid) {
                while (!lowerSt.isEmpty() && nums.get(lowerSt.get(lowerSt.size() - 1)) < num)
                    lowerSt.remove(lowerSt.size() - 1);
                lowerSt.add(i);
                lower.add(num);
            } else {

                res += lowerSt.size();
                while (!upperSt.isEmpty() && nums.get(upperSt.get(upperSt.size() - 1)) >= num)
                    upperSt.remove(upperSt.size() - 1);
                if (!upperSt.isEmpty()) {
                    int idx = Collections.binarySearch(lowerSt, upperSt.get(upperSt.size() - 1));
                    if (idx < 0)
                        idx = ~idx;
                    res -= idx;
                }
                upperSt.add(i);
                upper.add(num);
            }
        }

        return res + solve(lower, l, mid) + solve(upper, mid + 1, r);
    }
}
