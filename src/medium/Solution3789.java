package medium;

// 3789. Minimum Cost to Acquire Required Items

public class Solution3789 {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (need1 > need2) {
            int temp = need1;
            need1 = need2;
            need2 = temp;
            temp = cost1;
            cost1 = cost2;
            cost2 = temp;
        }
        int res1 = costBoth * need2;
        int res2 = cost1 * need1 + cost2 * need2;
        int res3 = costBoth * need1 + cost2 * (need2 - need1);
        return Math.min(res1, Math.min(res2, res3));
    }
}
