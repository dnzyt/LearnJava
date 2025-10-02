package medium;

// 1989. Maximum Number of People That Can Be Caught in Tag

public class Solution1989 {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int ans = 0;
        int n = team.length;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (team[i] == 0) continue;
            int left = Math.max(0, i - dist);
            int right = Math.min(n - 1, i + dist);
            int j = Math.max(p, left);
            while (j <= right) {
                if (team[j++] == 0) {
                    ans++;
                    break;
                }
            }
            p = j;
        }
        return ans;
    }
}
