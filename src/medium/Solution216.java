package medium;

// 216. Combination Sum III

import java.util.ArrayList;
import java.util.List;

public class Solution216 {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(9, k, n);
        return ans;
    }



    private void dfs(int i, int k, int target) {
        int d = k - path.size();
        if (target < 0 || target > (i + (i - d + 1)) * d / 2) return;
        if (k == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j > i - d; j --) {
            path.add(j);
            dfs(j + 1, k, target - j);
            path.remove(path.size() - 1);
        }
    }
}
