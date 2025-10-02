package easy;

// 2848. Points That Intersect With Cars

import java.util.List;

public class Solution2848 {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] s = new int[102];
        for (List<Integer> l : nums) {
            int start = l.get(0);
            int end = l.get(1);
            s[start] += 1;
            s[end + 1] -= 1;
        }
        int ans = 0;
        int sum = 0;
        for (int v : s) {
            sum += v;
            ans += sum > 0 ? 1 : 0;
        }
        return ans;
    }
}
