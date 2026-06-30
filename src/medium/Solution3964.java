package medium;

// 3964. Minimum Lights to Illuminate a Road

public class Solution3964 {
    public int minLights(int[] lights) {
        int n = lights.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (lights[i] <= 0)
                continue;
            int l = Math.max(0, i - lights[i]);
            int r = Math.min(n - 1, i + lights[i]);
            diff[l]++;
            diff[r + 1]--;
        }
        int ans = 0;
        int presum = 0;
        for (int i = 0; i < n; i++) {
            if (presum + diff[i] == 0) {
                ans++;
                int l = Math.max(0, i + 1 - 1);
                int r = Math.min(n - 1, i + 1 + 1);
                diff[l]++;
                diff[r + 1]--;
            }
            presum += diff[i];
        }
        return ans;
    }
}
