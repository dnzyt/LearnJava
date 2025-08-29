package medium;

// 1609. Even Odd Tree

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1609 {
    private List<Integer> pre = new ArrayList<>();
    public boolean isEvenOddTree(TreeNode root) {
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode root, int depth) {
        if (root == null) return true;
        if (depth % 2 == root.val % 2) return false;
        if (pre.size() == depth) pre.add(root.val);
        else {
            if (depth % 2 > 0 && pre.get(depth) <= root.val) {
                return false;
            }
            if (depth % 2 == 0 && pre.get(depth) >= root.val){
                return false;
            }
            pre.set(depth, root.val);
        }
        return dfs(root.left, depth + 1) && dfs(root.right, depth + 1);
    }
}
