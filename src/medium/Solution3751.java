package medium;

// 3751. Total Waviness of Numbers in Range I

public class Solution3751 {
    private char[] lowS;
    private char[] highS;
    private int diff;

    public int totalWaviness(int num1, int num2) {
        lowS = String.valueOf(num1).toCharArray();
        highS = String.valueOf(num2).toCharArray();
        diff = highS.length - lowS.length;
        return dfs(0, 0, 0, 0, true, true);
    }

    private int dfs(int i, int cmp, int pre, int wave, boolean isLowLimit, boolean isHighLimit) {
        int n = highS.length;
        if (i == n)
            return wave;
        int lo = isLowLimit && i >= diff ? lowS[i - diff] - '0' : 0;
        int hi = isHighLimit ? highS[i] - '0' : 9;
        boolean isNum = !isLowLimit || i > diff;
        int ans = 0;
        for (int d = lo; d <= hi; d++) {
            int newcmp = isNum ? Integer.compare(d, pre) : 0;
            ans += dfs(i + 1, newcmp, d, wave + ((newcmp * cmp < 0) ? 1 : 0), isLowLimit && d == lo, isHighLimit && d == hi);
        }
        return ans;
    }
}
