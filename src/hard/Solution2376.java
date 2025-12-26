package hard;

// 2376. Count Special Integers

import java.util.Arrays;

public class Solution2376 {
    private char[] s;
    private int[][] memo;

    public int countSpecialNumbers(int n) {
        s = Integer.toString(n).toCharArray();
        memo = new int[s.length][1 << 10];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(0, 0, true, false);
    }

    private int dfs(int i, int mask, boolean limited, boolean isNum) {
        if (i == s.length)
            return isNum ? 1 : 0;
        if (!limited && isNum && memo[i][mask] != -1) // 记忆话i和mask组成的状态，limited为true或者isNum为false只遍历一次
            return memo[i][mask];
        int ans = 0;
        if (!isNum)
            ans += dfs(i + 1, mask, false, false);
        int up = limited ? s[i] - '0' : 9;
        for (int x = isNum ? 0 : 1; x <= up; x++) {
            if (((mask >> x) & 1) == 0) {
                ans += dfs(i + 1, mask | (1 << x), limited && x == up, true);
            }
        }
        memo[i][mask] = ans;
        return ans;
    }
}
