package medium;

// 421. Maximum XOR of Two Numbers in an Array

import java.util.HashMap;
import java.util.Map;

public class Solution421 {
    private class Node {
        public Node[] next;
        public Node() {
            next = new Node[2];
        }
    }

    private class Trie {
        public Node root;
        public Trie() {
            root = new Node();
        }

        public void insert(int num) {
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int d = (num >> i) & 1;
                if (curr.next[d] == null)
                    curr.next[d] = new Node();
                curr = curr.next[d];
            }
        }

        public int findMax(int num) {
            int ans = 0;
            Node curr = root;
            for (int i = 31; i >= 0; i--) {
                int d = (num >> i) & 1;
                int want = d ^ 1;
                if (curr.next[want] != null) {
                    ans |= (1 << i);
                    curr = curr.next[want];
                } else {
                    curr = curr.next[d];
                }
            }
            return ans;
        }
    }



    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums)
            trie.insert(num);
        int ans = 0;
        for (int num : nums)
            ans = Math.max(ans, trie.findMax(num));
        return ans;
    }

}
