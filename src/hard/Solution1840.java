package hard;

// 1840. Maximum Building Height

import java.util.Arrays;

public class Solution1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        if (restrictions.length == 0)
            return n - 1;
        int l = restrictions.length;
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);

        restrictions[0][1] = Math.min(restrictions[0][0] - 1, restrictions[0][1]);
        for (int i = 1; i < l; i++) {
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i - 1][1] + restrictions[i][0] - restrictions[i - 1][0]);
        }
        for (int i = l - 2; i >= 0; i--) {
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]);
        }
        int ans = Math.max(restrictions[0][1] + (restrictions[0][0] - 1 - restrictions[0][1]) / 2, n - restrictions[l - 1][0] + restrictions[l - 1][1]);
        for (int i = 0; i < l - 1; i++) {
            int moves = restrictions[i + 1][0] - restrictions[i][0];
            int diff = Math.abs(restrictions[i][1] - restrictions[i + 1][1]);
            ans = Math.max(ans, (moves - diff) / 2 + Math.max(restrictions[i][1], restrictions[i + 1][1]));
        }
        return ans;
    }
}
