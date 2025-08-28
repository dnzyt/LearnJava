package medium;

// 107. Binary Tree Level Order Traversal II

import util.TreeNode;

import java.util.*;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            while (n-- > 0) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            ans.add(temp);
        }

        Collections.reverse(ans);
        return ans;
    }
}
