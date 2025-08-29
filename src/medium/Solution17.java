package medium;

// 17. Letter Combinations of a Phone Number

import java.util.*;

public class Solution17 {
    private static String[] MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        dfs(0, new char[digits.length()], digits.toCharArray());
        return ans;
    }

    private void dfs(int start, char[] path, char[] digits) {
        if (start == path.length) {
            ans.add(new String(path));
            return;
        }
        for (char c : MAPPING[digits[start] - '0'].toCharArray()) {
            path[start] = c;
            dfs(start + 1, path, digits);
        }
    }



}
