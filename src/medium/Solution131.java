package medium;

// 131. Palindrome Partitioning

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        dfs(0, s, path, ans);
        return ans;
    }

    private void dfs(int i, String s, List<String> path, List<List<String>> ans) {
        int n = s.length();
        if (i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < n; j++) {
            String sb = s.substring(i, j + 1);
            if (isValid(sb)) {
                path.add(sb);
                dfs(j + 1, s, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // 枚举选哪个
    // 枚举每一个分割点，决定分割还是不分割
    public List<List<String>> partition2(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        dfs(0, 0, s, path, ans);
        return ans;
    }

    private void dfs(int i, int start, String s, List<String> path, List<List<String>> ans) {
        int n = s.length();
        if (i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i < n - 1)
            dfs(i + 1, start, s, path, ans);
        String sub = s.substring(start, i + 1);
        if (isValid(sub)) {
            path.add(sub);
            dfs(i + 1, i + 1, s, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
