package easy;

// 338. Counting Bits

public class Solution338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        if (n == 0) return ans;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }

        return ans;
    }
}
