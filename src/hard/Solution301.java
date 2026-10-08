package hard;

// 301. Remove Invalid Parentheses

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution301 {

    // BFS， 每次删除一个字符，最先成为valid的字符串就是答案
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        set.add(s);

        while (true) {
            for (String x : set) {
                if (isValid(x))
                    ans.add(x);
            }
            if (!ans.isEmpty())
                return ans;
            Set<String> curr = new HashSet<>();
            for (String x : set) {
                for (int i = 0; i < x.length(); i++)
                    curr.add(x.substring(0, i) + x.substring(i + 1));
            }
            set = curr;
        }
    }

    private boolean isValid(String s) {
        int left = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                left++;
            else if (ch == ')') {
                if (left == 0)
                    return false;
                left--;
            }
        }
        return left == 0;
    }

    // 选 或 不选
    public List<String> removeInvalidParentheses2(String s) {
        int n = s.length();
        int target = 0, left = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                target++;
                left++;
            }
            else if (ch == ')' && left > 0)
                left--;
        }
        target -= left;
        List<String> ans = new ArrayList<>();
        dfs(0, 0, 0, target, s.toCharArray(), new StringBuilder(), ans);
        return ans;
    }

    private void dfs(int i, int left, int right, int target, char[] s, StringBuilder path, List<String> ans) {
        int n = s.length;
        if (left < right || left > target || left + right + n - i < target * 2)
            return;
        if (i == n) {
            ans.add(path.toString());
            return;
        }
        char ch = s[i];
        if (ch == '(' || ch == ')') {
            int j = i + 1;
            while (j < n && s[j] == ch) {
                j++;
            }
            dfs(j, left, right, target, s, path, ans);
        }
        if (ch == '(')
            left++;
        else if (ch == ')')
            right++;
        path.append(ch);
        dfs(i + 1, left, right, target, s, path, ans);
        path.deleteCharAt(path.length() - 1);
    }

    // 枚举选哪个
    public List<String> removeInvalidParentheses3(String s) {
        int target = 0, left = 0, alpha = 0;
        char[] chs = s.toCharArray();
        for (char ch : chs) {
            if (ch == '(') {
                target++;
                left++;
            } else if (ch == ')') {
                if (left > 0)
                    left--;
            } else
                alpha++;
        }
        target -= left;
        int total = target * 2 + alpha;
        List<String> ans = new ArrayList<>();
        dfs(0, 0, 0, target, total, chs, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(int i, int left, int right, int target, int total, char[] s, StringBuilder sb, List<String> ans) {
        int n = s.length;
        if (left < right || left > target || left + right + n - i < target * 2)
            return;
        if (sb.length() == total) {
            ans.add(sb.toString());
            return;
        }
        for (int j = i; j < n; j++) {
            char ch = s[j];
            if (j > i && ch == s[j - 1])
                continue;
            sb.append(ch);
            dfs(j + 1, left + (s[j] == '(' ? 1 : 0), right + (s[j] == ')' ? 1 : 0), target, total, s, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
            if (ch != '(' && ch != ')')
                break;
        }
    }



}
