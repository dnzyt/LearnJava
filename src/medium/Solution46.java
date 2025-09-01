package medium;

// 46. Permutations

import java.util.*;


public class Solution46 {
    // O(n*n!)
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().toList();
        Set<Integer> s = new HashSet<>(l);
        boolean[] onPath = new boolean[nums.length];
        dfs(nums, onPath);
        return ans;
    }

    private void dfs(int[] nums, boolean[] onPath) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (onPath[i]) continue;
            onPath[i] = true;
            path.add(nums[i]);
            dfs(nums, onPath);
            path.remove(nums[i]);
            onPath[i] = false;
        }
    }

}
