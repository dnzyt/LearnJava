package medium;

// 1302. Deepest Leaves Sum

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution1302 {
    private List<Integer> pre = new ArrayList<>();

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return pre.get(pre.size() - 1);
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (pre.size() == depth) pre.add(root.val);
        else {
            int val = pre.get(depth);
            pre.set(depth, val + root.val);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        return;
    }

    // BFS
    public int deepestLeavesSum2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int ans = 0;
        while (!q.isEmpty()) {
            Queue<TreeNode> temp = q;
            q = new ArrayDeque<>();
            ans = 0;
            while (!temp.isEmpty()) {
                TreeNode curr = temp.poll();
                ans += curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        return ans;
    }
}
