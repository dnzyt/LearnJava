package hard;

// 968. Binary Tree Cameras

import util.TreeNode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution968 {
    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        return Math.min(res[0], res[2]);
    }

    // 当前节点装摄像头
    // 当前节点不装摄像头且父节点装摄像头
    // 当前节点不装摄像头且儿子节点装摄像头
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{Integer.MAX_VALUE, 0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int a = IntStream.of(left).min().getAsInt() + IntStream.of(right).min().getAsInt();
        int b = Math.min(left[0] + right[2], Math.min(left[2] + right[2], left[2] + right[0]));
        int c = Math.min(left[0] + right[0], Math.min(left[0] + right[2], left[2] + right[0]));
        return new int[]{a, b, c};
    }
}
