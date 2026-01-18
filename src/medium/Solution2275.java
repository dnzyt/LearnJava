package medium;

// 2275. Largest Combination With Bitwise AND Greater Than Zero

public class Solution2275 {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : candidates) {
                if (((num >> i) & 1) == 0)
                    cnt++;
            }
            res = Math.max(res, n - cnt);
        }
        return res;
    }

}
