package medium;

// 3043. Find the Length of the Longest Common Prefix

import java.util.Map;

public class Solution3043 {
    class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[10];
        }
    }

    private TrieNode root;

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        root = new TrieNode();
        for (int num : arr1)
            insert(num);
        int ans = 0;
        for (int num : arr2)
            ans = Math.max(ans, search(num));
        return ans;
    }

    private void insert(int num) {
        String s = String.valueOf(num);
        TrieNode curr = root;
        for (char ch : s.toCharArray()) {
            int p = ch - '0';
            if (curr.children[p] == null)
                curr.children[p] = new TrieNode();
            curr = curr.children[p];
        }
    }

    private int search(int num) {
        TrieNode curr = root;
        String s = String.valueOf(num);
        int ans = 0;
        for (char ch : s.toCharArray()) {
            int p = ch - '0';
            if (curr.children[p] == null)
                return ans;
            ans++;
            curr = curr.children[p];
        }
        return ans;
    }
}
