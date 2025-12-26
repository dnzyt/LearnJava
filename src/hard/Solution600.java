package hard;

// 600. Non-negative Integers without Consecutive Ones

import java.util.Arrays;

public class Solution600 {
    private char[] s;
    private int[][] memo;

    public int findIntegers(int n) {
        s = Integer.toBinaryString(n).toCharArray(); // 5 -> 101 (no leading zeros)
        memo = new int[s.length][2];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(0, 0, true);
    }

    private int dfs(int i, int prevOne, boolean limited) {
        if (i == s.length)
            return 1;
        if (!limited && memo[i][prevOne] != -1) {
            return memo[i][prevOne];
        }
        int up = limited ? s[i] - '0' : 1;
        int ans = dfs(i + 1, 0, limited && up == 0);
        if (prevOne == 0 && up == 1)
            ans += dfs(i + 1, 1, limited);
        if (!limited) {
            memo[i][prevOne] = ans;
        }
        return ans;
    }

}
