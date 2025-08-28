package medium;

// 513. Find Bottom Left Tree Value

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        TreeNode ans = null;
        while (!q.isEmpty()) {
            ans = q.poll();
            if (ans.right != null) q.offer(ans.right);
            if (ans.left != null) q.offer(ans.left);
        }
        return ans.val;
    }
}
