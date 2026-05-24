package medium;

// 254. Factor Combinations

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        return dfs(n, 2);
    }

    private List<List<Integer>> dfs(int n, int left) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = left; i < (int) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                ans.add(new ArrayList<>(List.of(i, n / i)));
                for (List<Integer> temp : dfs(n / i, i)) {
                    temp.add(i);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
