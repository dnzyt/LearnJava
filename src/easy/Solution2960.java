package easy;

// 2960. Count Tested Devices After Test Operations

public class Solution2960 {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        int n = batteryPercentages.length;
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] + s > 0) {
                ans++;
                s--;
            }
        }

        return ans;
    }
}
