package medium;

// 133. Clone Graph

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution133 {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Map<Integer, Node> memo = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (memo.containsKey(node.val))
            return memo.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<>());
        memo.put(node.val, newNode);
        for (Node nei : node.neighbors) {
            newNode.neighbors.add(cloneGraph(nei));
        }

        return newNode;
    }


}
