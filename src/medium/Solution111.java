package medium;

// 111. Minimum Depth of Binary Tree

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            depth ++;
            int n = q.size();
            while (n-- > 0) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) return depth;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
        }
        return Integer.MAX_VALUE;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth2(root.right) + 1;
        if (root.right == null) return minDepth2(root.left) + 1;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return Math.min(l, r) + 1;

    }
}
