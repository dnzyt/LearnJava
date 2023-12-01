package hard;

// 297. Serialize and Deserialize Binary Tree


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution297 {
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

    class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> res = new ArrayList<>();
            inorder(root, res);
            StringBuilder sb = new StringBuilder();
            return String.join(",", res.toArray(String[]::new));
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> q = new LinkedList<>();
            String[] nums = data.split(",");
            for (int i = 0; i < nums.length; i++)
                q.add(String.valueOf(nums[i]));

            return desc(q);
        }

        private void inorder(TreeNode root, List<String> res) {
            if (root == null) {
                res.add("#");
                return;
            }
            res.add(String.valueOf(root.val));
            inorder(root.left, res);
            inorder(root.right, res);
        }

        private TreeNode desc(Deque<String> q) {
            String curr = q.pollFirst();
            if (curr.equals("#"))
                return null;
            TreeNode root = new TreeNode(Integer.parseInt(curr));
            root.left = desc(q);
            root.right = desc(q);
            return root;
        }
    }

}
