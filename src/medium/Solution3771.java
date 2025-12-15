package medium;

// 3771. Total Score of Dungeon Runs

import java.util.Arrays;

public class Solution3771 {
    // 贡献法
    // 横着不好算，竖着算
    // 算每一个房子对整体的贡献
    public long totalScore(int hp, int[] damage, int[] requirement) {
        long ans = 0;
        int n = damage.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + damage[i];

        for (int i = 0; i < n; i++) {
            int low = presum[i + 1] + requirement[i] - hp;
            int idx = Arrays.binarySearch(presum, 0, i + 1, low);
            if (idx < 0)
                idx = ~idx;
            ans += (i - idx + 1);
        }
        return ans;
    }
}
