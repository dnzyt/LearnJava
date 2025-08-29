package medium;

// 93. Restore IP Addresses

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    private List<String> path = new ArrayList<>();
    private List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 4);
        return ans;
    }

    private void dfs(String s, int start, int remain) {
        if (remain < 0) return;
        if (start == s.length()) {
            if (remain == 0) {
                ans.add(String.join(".", path));
            }
            return;
        }
        int j = start + 1;
        while (j <= s.length() && j <= start + 3) {
            String sub = s.substring(start, j);
            if (isValid(sub)) {
                path.add(sub);
                dfs(s, j, remain - 1);
                path.remove(path.size() - 1);
            }
            j ++;
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
