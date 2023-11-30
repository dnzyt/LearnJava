package medium;

// 105. Construct Binary Tree from Preorder and Inorder Traversal

import java.util.Arrays;

public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);

        int idx = Arrays.stream(inorder).boxed().toList().indexOf(preorder[0]);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + idx);
        int[] rightPreorder = Arrays.copyOfRange(preorder, idx + 1, preorder.length);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx);
        int[] rightInorder = Arrays.copyOfRange(inorder, idx + 1, inorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }

}
