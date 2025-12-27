package easy;

// 559. Maximum Depth of N-ary Tree

import java.util.List;


public class Solution559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        return dfs(root);
    }

    private int dfs(Node node) {
        if (node == null)
            return 0;
        int d = 0;
        for (Node nxt : node.children) {
            d = Math.max(dfs(nxt), d);
        }
        return d + 1;
    }
}
