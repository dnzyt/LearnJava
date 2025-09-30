package medium;

// 1744. Can You Eat Your Favorite Candy on Your Favorite Day?

public class Solution1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] presum = new long[candiesCount.length + 1];
        for (int i = 0; i < candiesCount.length; i++) {
            presum[i + 1] = presum[i] + candiesCount[i];
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ft = queries[i][0];
            int fd = queries[i][1];
            int dc = queries[i][2];
            ans[i] = (long) (fd + 1) * dc > presum[ft] && fd < presum[ft + 1];
        }
        return ans;
    }

}
