package hard;

// 1819. Number of Different Subsequences GCDs

public class Solution1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int mx = Integer.MIN_VALUE;
        boolean[] has = new boolean[mx + 1];
        for (int num : nums) {
            mx = Math.max(mx, num);
            has[num] = true;
        }

        int ans = 0;
        for (int i = 1; i <= mx; i++) {
            int g = 0;
            for (int j = i; j <= mx; j += i) {
                if (has[j]) {
                    g = gcd(g, j);
                    if (i == g) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private int gcd(int x, int y) {
        while (x != 0) {
            int tmp = x;
            x = y % x;
            y = tmp;
        }
        return y;
    }
}
