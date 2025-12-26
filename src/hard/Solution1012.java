package hard;

// 1012. Numbers With Repeated Digits

import java.util.Arrays;

public class Solution1012 {

    private char[] s;
    private int[][][] memo;


    // 数位DP
    // 这道题也可以反过来想，先求出一次重复都没有的情况，然后用n减去这些情况出现的次数
    // 下面的方法是正面算
    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        memo = new int[s.length][1 << 10][2];
        for (int[][] q : memo)
            for (int[] row : q)
                Arrays.fill(row, -1);

        return dfs(0, 0, false, true, false);
    }


    private int dfs(int i, int mask, boolean repeated, boolean limited, boolean isNum) {
        if (i == s.length)
            return isNum && repeated ? 1 : 0;

        if (!limited && isNum && memo[i][mask][repeated ? 1 : 0] != -1)
            return memo[i][mask][repeated ? 1 : 0];
        int ans = 0;
        if (!isNum)
            ans += dfs(i + 1, 0, false, false, false);
        int up = limited ? s[i] - '0' : 9;
        for (int x = isNum ? 0 : 1; x <= up; x++) {
            ans += dfs(i + 1, mask | (1 << x), repeated | (((mask >> x) & 1) > 0), limited && x == up, true);
        }
        if (!limited && isNum)
            memo[i][mask][repeated ? 1 : 0] = ans;
        return ans;
    }
}
