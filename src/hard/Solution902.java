package hard;

// 902. Numbers At Most N Given Digit Set

import java.util.Arrays;

public class Solution902 {
    private char[] s;
    private int[] d;
    private int[] memo;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = Integer.toString(n).toCharArray();
        d = Arrays.stream(digits).mapToInt(Integer::parseInt).toArray();
        memo = new int[s.length];
        Arrays.fill(memo, -1);
        return dfs(0, true, false);
    }

    private int dfs(int i, boolean limited, boolean isNum) {
        if (i == s.length)
            return isNum ? 1 : 0;
        if (!limited && isNum && memo[i] != -1)
            return memo[i];
        int ans = 0;
        if (!isNum)
            ans += dfs(i + 1, false, false);
        int up = limited ? s[i] - '0' : 9;
        for (int num : d) {
            if (num > up) break;
            ans += dfs(i + 1, limited && num == s[i] - '0', true);
        }
        if (!limited && isNum)
            memo[i] = ans;
        return ans;
    }
}
