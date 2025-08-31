package medium;

// 22. Generate Parentheses

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    private char[] path;
    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        path = new char[n * 2];
        dfs(0, 0, n);
        return ans;
    }

    private void dfs(int i, int open, int n) {
        if (i == n * 2) {
            ans.add(new String(path));
            return;
        }
        if (open < n) {
            path[i] = '(';
            dfs(i + 1, open + 1, n);
        }
        if (i - open < open) {
            path[i] = ')';
            dfs(i + 1, open, n);
        }
    }
}
