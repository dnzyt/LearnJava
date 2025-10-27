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
}
