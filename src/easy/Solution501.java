package easy;

// 501. Find Mode in Binary Search Tree

import util.TreeNode;

import java.util.*;

// 中序遍历
public class Solution501 {
    private int base;
    private int mx = Integer.MIN_VALUE;
    private int cnt;
    private List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode node) {
        if (node.left != null)
            dfs(node.left);
        if (node.val == base) {
            cnt++;
        } else {
            base = node.val;
            cnt = 1;
        }
        if (cnt == mx)
            ans.add(base);
        else if (cnt > mx) {
            ans.clear();
            ans.add(base);
            mx = cnt;
        }
        if (node.right != null)
            dfs(node.right);

    }

}
