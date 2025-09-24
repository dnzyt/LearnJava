package medium;

// 2555. Maximize Win From Two Segments

public class Solution2555 {
    // 双指针+dp
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] preMax = new int[n + 1];
        int ans = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            while (prizePositions[i] - prizePositions[left] > k) {
                left++;
            }
            ans = Math.max(ans, i - left + 1 + preMax[left]);
            preMax[i + 1] = Math.max(preMax[i], i - left + 1);
        }
        return ans;
    }
}
