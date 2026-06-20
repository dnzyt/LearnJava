package hard;

// 3093. Longest Common Suffix Queries

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3093 {

    class TrieNode {
        public TrieNode[] children;
        public int smallestIdx;

        public TrieNode() {
            children = new TrieNode[26];
            smallestIdx = -1;
        }
    }

    private TrieNode root;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        // [word.length, index]
        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < wordsContainer.length; i++)
            l.add(new int[]{wordsContainer[i].length(), i});
        Collections.sort(l, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        root = new TrieNode();
        root.smallestIdx = l.getFirst()[1];
        for (int[] a : l) {
            addWord(wordsContainer[a[1]], a[1]);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++)
            ans[i] = search(wordsQuery[i]);
        return ans;
    }

    private void addWord(String word, int idx) {
        TrieNode curr = root;
        char[] chs = word.toCharArray();
        for (int i = word.length() - 1; i >= 0; i--) {
            int pos = chs[i] - 'a';
            if (curr.children[pos] == null) {
                curr.children[pos] = new TrieNode();
                curr.children[pos].smallestIdx = idx;
            }
            curr = curr.children[pos];
        }
    }

    private int search(String word) {
        TrieNode curr = root;
        int n = word.length();
        char[] chs = word.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            int pos = chs[i] - 'a';
            if (curr.children[pos] == null)
                return curr.smallestIdx;
            curr = curr.children[pos];
        }
        return curr.smallestIdx;
    }
}
