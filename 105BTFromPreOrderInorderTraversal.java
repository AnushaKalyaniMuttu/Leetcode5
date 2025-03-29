// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element of preorder is always the root node
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find the index of the root in inorder array
        int inRoot = inStart;
        while (inorder[inRoot] != root.val) {
            inRoot++;
        }

        int leftTreeSize = inRoot - inStart;

        // Construct left and right subtrees recursively
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, inRoot - 1);
        root.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd, inorder, inRoot + 1, inEnd);

        return root;
    }
}
