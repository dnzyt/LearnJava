package easy;

// 944. Delete Columns to Make Sorted

public class Solution944 {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, n = strs[0].length();
        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i + 1 < m && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
