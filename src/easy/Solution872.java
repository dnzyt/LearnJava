package easy;

// 872. Leaf-Similar Trees

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution872 {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();
        dfs(root1, seq1);
        dfs(root2, seq2);
//        return seq1.equals(seq2);
        if (seq1.size() != seq2.size())
            return false;
        for (int i = 0; i < seq1.size(); i++)
            if (!seq1.get(i).equals(seq2.get(i)))
                return false;
        return true;
    }


    private void dfs(TreeNode root, List<Integer> seq) {
        if (root.left == null && root.right == null) {
            seq.add(root.val);
            return;
        }
        if (root.left != null)
            dfs(root.left, seq);
        if (root.right != null)
            dfs(root.right, seq);
    }
}
