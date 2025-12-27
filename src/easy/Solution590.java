package easy;

// 590. N-ary Tree Postorder Traversal

import java.util.ArrayList;
import java.util.List;

public class Solution590 {
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

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;
    }

    private void dfs(Node node) {
        if (node == null)
            return;
        for (Node nxt : node.children)
            dfs(nxt);
        ans.add(node.val);
    }
}
