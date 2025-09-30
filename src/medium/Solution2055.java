package medium;

// 2055. Plates Between Candles

public class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        s = "|" + s + "|";
        int n = s.length();
        int[] l = new int[n];
        int[] r = new int[n];
        int lIdx = 0;
        int rIdx = n - 1;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + (s.charAt(i) == '*' ? 1 : 0);
            if (s.charAt(i) == '|')
                lIdx = i;
            l[i] = lIdx;
            if (s.charAt(n - 1 - i) == '|')
                rIdx = n - 1 - i;
            r[n - 1 - i] = rIdx;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = r[queries[i][0] + 1];
            int right = l[queries[i][1] + 1];
            ans[i] = Math.max(0, presum[right + 1] - presum[left + 1]);
        }
        return ans;
    }
}
