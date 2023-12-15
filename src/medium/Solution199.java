package medium;

// 199. Binary Tree Right Side View

import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root == null)
            return res;
        q.offer(root);
        while (!q.isEmpty()) {
            int l = q.size();
            List<Integer> temp = new ArrayList<>();
            while (l > 0) {
                TreeNode curr = q.poll();
                l --;
                temp.add(curr.val);
                if (curr.left != null)
                    q.offerLast(curr.left);
                if (curr.right != null)
                    q.offerLast(curr.right);
            }
            res.add(temp.get(temp.size() - 1));
        }

        return res;
    }

}
