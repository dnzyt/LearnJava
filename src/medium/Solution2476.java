package medium;

// 2476. Closest Nodes Queries in a Binary Search Tree

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);
        int n = arr.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) { nums[i] = arr.get(i); }
        List<List<Integer>> ans = new ArrayList<>();
        for (int query : queries) {
            int idx = lowerBound(nums, query);
            int mn;
            int mx;
            if (idx == n) { mn = nums[idx - 1]; }
            else if (nums[idx] == query) { mn = nums[idx]; }
            else if (idx == 0) { mn = -1; }
            else { mn = nums[idx - 1]; }

            if (idx == n) { mx = -1; }
            else { mx = nums[idx]; }
            ans.add(List.of(mn, mx));
        }
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }

    private int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
