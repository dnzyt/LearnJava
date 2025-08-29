package medium;

// 131. Palindrome Partitioning

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    private List<String> path = new ArrayList<>();
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, s);
        return ans;
    }

    private boolean check(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i ++;
            j --;
        }
        return true;
    }

    private void dfs(int i, String s) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            if (check(s.substring(i, j))) {
                path.add(s.substring(i, j));
                dfs(j, s);
                path.remove(path.size() - 1);
            }
        }
    }
}
