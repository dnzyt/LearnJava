package medium;

// 2196. Create Binary Tree From Descriptions

import util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> roots = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] d : descriptions) {
            int p = d[0], curr = d[1], isLeft = d[2];
            TreeNode parent = map.computeIfAbsent(p, i -> {
                roots.add(p);
                return new TreeNode(p);
            });
            TreeNode child = map.computeIfAbsent(curr, i -> new TreeNode(curr));
            roots.remove(curr);
            if (isLeft == 1)
                parent.left = child;
            else
                parent.right = child;
        }
        for (int r : roots)
            return map.get(r);
        return null;
    }
}
