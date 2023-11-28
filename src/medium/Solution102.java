package medium;

// 102. Binary Tree Level Order Traversal

import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.offer(root);
        while (!q.isEmpty()) {
            int l = q.size();
            List<Integer> level = new ArrayList<>();
            while (l > 0) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
                l --;
            }
            res.add(level);
        }


        return res;
    }

}
