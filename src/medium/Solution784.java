package medium;

// 784. Letter Case Permutation

import java.util.ArrayList;
import java.util.List;

public class Solution784 {
    private List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] path = new char[s.length()];
        dfs(s, 0, path);
        return ans;
    }

    private void dfs(String s, int i, char[] path) {
        if (i == s.length()) {
            ans.add(String.valueOf(path));
            return;
        }
        if (Character.isDigit(s.charAt(i))) {
            path[i] = s.charAt(i);
            dfs(s, i + 1, path);
        } else {
            path[i] = Character.toUpperCase(s.charAt(i));
            dfs(s, i + 1, path);
            path[i] = Character.toLowerCase(s.charAt(i));
            dfs(s, i + 1, path);
        }
    }
}
