package medium;

// 2583. Kth Largest Sum in a Binary Tree

import util.TreeNode;

import java.util.*;

public class Solution2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> nums = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            long sum = 0;
            while (n-- > 0) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            nums.add(sum);
        }
        if (k > nums.size()) return -1;
        Collections.sort(nums);
        return nums.get(nums.size() - k);
    }
}
