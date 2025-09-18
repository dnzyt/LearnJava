package easy;

// 2511. Maximum Enemy Forts That Can Be Captured

public class Solution2511 {
    public int captureForts(int[] forts) {
        int ans = Integer.MIN_VALUE;
        int idx = -1;
        int n = forts.length;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1)
                idx = i;
            else if (forts[i] == -1 && idx != -1) {
                ans = Math.max(ans, i - idx + 1);
                idx = -1;
            }
        }
        idx = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (forts[i] == 1)
                idx = i;
            else if (forts[i] == -1 && idx != -1) {
                ans = Math.max(ans, idx - i + 1);
                idx = -1;
            }
        }
        return ans;
    }
}
