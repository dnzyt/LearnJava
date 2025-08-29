package medium;

// 116. Populating Next Right Pointers in Each Node

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Queue<Node> temp = new ArrayDeque<>();
            while (!q.isEmpty()) {
                Node curr = q.poll();
                if (!q.isEmpty()) {
                    curr.next = q.peek();
                }
                if (curr.left != null) temp.offer(curr.left);
                if (curr.right != null) temp.offer(curr.right);
            }
            q = temp;
        }
        return root;
    }

    private List<Node> pre = new ArrayList<>();

    public Node connect2(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs(Node root, int depth) {
        if (root == null) return;
        if (pre.size() == depth) pre.add(root);
        else {
            pre.get(depth).next = root;
            pre.set(depth, root);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        return;
    }
}
