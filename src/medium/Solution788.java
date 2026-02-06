package medium;

// 788. Rotated Digits

public class Solution788 {
    private static final int[] DIFFS = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        char[] num = Integer.toString(n).toCharArray();
        return dfs(0, false, true, num);
    }

    private int dfs(int i, boolean hasDiff, boolean isLimited, char[] num) {
        if (i == num.length)
            return hasDiff ? 1 : 0;
        int res = 0;
        int up = isLimited ? num[i] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            if (DIFFS[d] != -1)
                res += dfs(i + 1, hasDiff || DIFFS[d] == 1, isLimited && d == up, num);
        }
        return res;
    }
}
