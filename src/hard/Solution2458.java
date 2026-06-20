package hard;

// 2458. Height of Binary Tree After Subtree Removal Queries

import util.TreeNode;

public class Solution2458 {

    private static final int N = 100000;

    private int[] timestamp;
    private int[] depth;
    private int[] sz;
    private int cnt;

    public int[] treeQueries(TreeNode root, int[] queries) {
        timestamp = new int[N + 1];
        depth = new int[N + 2];
        sz = new int[N + 1];

        dfs(root, 0);
        int[] left = new int[N + 1];
        int[] right = new int[N + 2];
        int leftMX = 0;
        int rightMX = 0;
        for (int i = 1; i <= N; i++) {
            leftMX = Math.max(leftMX, depth[i - 1]);
            left[i] = leftMX;
            rightMX = Math.max(rightMX, depth[N + 2 - i]);
            right[N + 1 - i] = rightMX;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int curr = timestamp[queries[i]];
            ans[i] = Math.max(left[curr], right[curr + sz[curr] - 1]);
        }
        return ans;
    }

    private int dfs(TreeNode root, int d) {
        if (root == null)
            return 0;
        int val = root.val;
        timestamp[val] = ++cnt;
        depth[timestamp[val]] = d;
        int s = 0;
        s += dfs(root.left, d + 1);
        s += dfs(root.right, d + 1);
        sz[timestamp[val]] = 1 + s;
        return sz[timestamp[val]];
    }
}
