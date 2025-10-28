package medium;

// 1111. Maximum Nesting Depth of Two Valid Parentheses Strings

public class Solution1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        char[] chs = seq.toCharArray();
        int[] ans = new int[n];
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (chs[i] == '(') {
                d++;
                ans[i] = d % 2;
            } else {
                ans[i] = d % 2;
                d--;
            }
        }
        return ans;
    }
}
