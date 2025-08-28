package medium;

// 2096. Step-By-Step Directions From a Binary Tree Node to Another

import util.TreeNode;

public class Solution2096 {
    private String path;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, new StringBuilder(), startValue);
        String startPath = new String(path);
        dfs(root, new StringBuilder(), destValue);
        String destPath = new String(path);
        int count = 0;
        for (int i = 0; i < Math.min(startPath.length(), destPath.length()); i++) {
            if (startPath.charAt(i) == destPath.charAt(i)) count ++;
            else break;
        }
        startPath = startPath.substring(count);
        destPath = destPath.substring(count);
        return "U".repeat(startPath.length()) + destPath;
    }

    private boolean dfs(TreeNode root, StringBuilder p, int target) {
        if (root == null) return false;
        if (root.val == target) {
            path = p.toString();
            return true;
        }
        if (dfs(root.left, p.append('L'), target)) {
            return true;
        }
        p.deleteCharAt(p.length() - 1);
        if (dfs(root.right, p.append('R'), target)) {
            return true;
        }
        p.deleteCharAt(p.length() - 1);
        return false;
    }
}
