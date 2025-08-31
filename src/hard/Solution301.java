package hard;

// 301. Remove Invalid Parentheses

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution301 {

    // 把需要删除的点记录在path中
    private List<Integer> path = new ArrayList<>();
    private Set<String> p = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0; // 需要删除的左括号数量
        int right = 0; // 需要删除的右括号数量
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') left ++;
            if (c[i] == ')') {
                if (left > 0) {
                    left --;
                } else {
                    right ++;
                }
            }
        }
        dfs(0, s.toCharArray(), left, right);
        List<String> ans = new ArrayList<>();
        ans.addAll(p);
        return ans;
    }

    private void dfs(int i, char[] s, int left, int right) {
        if (left + right > s.length - i) return;
        if (i == s.length) {
            if (left == 0 && right == 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < s.length; j++) {
                    if (!path.contains(j)) sb.append(s[j]);
                }
                String c = sb.toString();
                if (isValid(c)) p.add(c);  // 判断删除括号之后的string是否合法
            }
            return;
        }

        // 用一次删除括号的机会还是不用
        if (s[i] == '(' && left > 0) {
            path.add(i);
            dfs(i + 1, s, left - 1, right);
            path.remove(path.size() - 1);
        }
        if (s[i] == ')' && right > 0) {
            path.add(i);
            dfs(i + 1, s, left, right - 1);
            path.remove(path.size() - 1);
        }
        dfs(i + 1, s, left, right);
    }

    private boolean isValid(String s) {
        char[] a = s.toCharArray();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') count ++;
            else if (a[i] == ')') {
                count --;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}
