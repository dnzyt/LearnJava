package medium;

// 357. Count Numbers with Unique Digits

public class Solution357 {

    private int ans;
    public int countNumbersWithUniqueDigits(int n) {
        boolean[] onPath = new boolean[10];
        dfs(1, n, onPath);
        return ans + 1;
    }

    private void dfs(int i, int n, boolean[] onPath) {
        if (i > n) return;
        for (int j = 0; j < 10; j ++) {
            if (onPath[j]) continue;
            if (i == 1 && j == 0) continue;
            onPath[j] = true;
            ans ++;
            dfs(i + 1, n, onPath);
            onPath[j] = false;
        }
    }


}
