package medium;

// 103. Binary Tree Zigzag Level Order Traversal

import util.TreeNode;

import java.util.*;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> temp = new ArrayList<>(n);
            while (n-- > 0) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            if (ans.size() % 2 > 0) Collections.reverse(temp);
            ans.add(temp);
        }
        return ans;
    }
}
