package medium;

// 39. Combination Sum

import java.util.ArrayList;
import java.util.List;

public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combination(candidates, 0, target);
    }

    private List<List<Integer>> combination(int[] candidates, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        for (int i = start; i < candidates.length; i++) {
            int curr = candidates[i];
            if (target < curr) continue;
            for (List<Integer> temp : combination(candidates, i, target - curr)) {
                temp.add(curr);
                res.add(temp);
            }
        }
        return res;
    }
}
