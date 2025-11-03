package medium;

// 3597. Partition String

import java.util.ArrayList;
import java.util.List;

public class Solution3597 {
    record Node(Node[] children) {
        public Node() {
            this(new Node[26]);
        }
    }

    public List<String> partitionString(String s) {
        List<String> ans = new ArrayList<>();
        Node root = new Node();
        Node curr = root;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (curr.children[c] == null) {
                curr.children[c] = new Node();
                ans.add(s.substring(left, i + 1));
                curr = root;
                left = i + 1;
            } else {
                curr = curr.children[c];
            }
        }
        return ans;
    }
}
