package medium;

// 1105. Filling Bookcase Shelves

import java.util.Arrays;

public class Solution1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = books[0][1];

        // 以i为结尾的最后一本书可以与哪些书组成最后一行
        for (int i = 1; i < n; i++) {
            int maxHeight = 0;
            int thickness = 0;
            for (int j = i; j >= 0; j--) {
                if (thickness + books[j][0] <= shelfWidth) {
                    maxHeight = Math.max(maxHeight, books[j][1]);
                    dp[i] = j == 0 ? maxHeight : Math.min(dp[i], dp[j - 1] + maxHeight);
                    thickness += books[j][0];
                } else {
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}
