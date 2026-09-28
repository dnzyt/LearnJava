package medium;

// 1190. Reverse Substrings Between Each Pair of Parentheses

import java.util.ArrayList;
import java.util.List;

public class Solution1190 {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder l = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                while (sb.charAt(sb.length() - 1) != '(') {
                    l.append(sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(l);
                l = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 递归解法
    public String reverseParentheses2(String s) {
        char[] chs = s.toCharArray();
        return dfs(chs).toString();
    }

    private int i;

    private StringBuilder dfs(char[] chs) {
        StringBuilder sb = new StringBuilder();
        while (i < chs.length) {
            char c = chs[i++];
            if (c == '(') {
                sb.append(dfs(chs));
            } else if (c == ')') {
                return sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb;
    }
}
