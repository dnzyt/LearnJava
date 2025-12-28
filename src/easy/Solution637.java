package easy;

// 637. Average of Levels in Binary Tree

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int k = q.size();
            int cnt = 0;
            double sum = 0;
            while (k-- > 0) {
                TreeNode curr = q.poll();
                sum += curr.val;
                cnt++;
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            ans.add(sum / cnt);
        }
        return ans;
    }
}
