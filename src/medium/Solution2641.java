package medium;

// 2641. Cousins in Binary Tree II

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution2641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        root.val = 0;
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sum = 0;
            for (TreeNode curr : q) {
                if (curr.left != null) sum += curr.left.val;
                if (curr.right != null) sum += curr.right.val;
            }
            List<TreeNode> temp = q;
            q = new ArrayList<>();
            for (TreeNode curr : temp) {
                int val = sum;
                if (curr.left != null) val -= curr.left.val;
                if (curr.right != null) val -= curr.right.val;
                if (curr.left != null) {
                    curr.left.val = val;
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = val;
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}
