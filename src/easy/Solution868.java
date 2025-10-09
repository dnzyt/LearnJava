package easy;

// 868. Binary Gap

public class Solution868 {
    public int binaryGap(int n) {
        int ans = 0;
        int zeros = Integer.numberOfTrailingZeros(n);
        while (n > 0) {
            int t = Integer.numberOfTrailingZeros(n);
            ans = Math.max(ans, t - zeros);
            zeros = t;
            n &= (n - 1);
        }
        return ans;
    }
}
