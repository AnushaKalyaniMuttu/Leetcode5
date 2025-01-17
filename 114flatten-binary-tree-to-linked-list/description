/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten the left subtree
        if (root.left != null) {
            flatten(root.left);
            
            // Save the right child to reconnect later
            TreeNode tempRight = root.right;
            
            // Move the left subtree to the right
            root.right = root.left;
            root.left = null;  // Set the left child to null
            
            // Find the rightmost node of the flattened left subtree
            TreeNode current = root.right;
            while (current.right != null) {
                current = current.right;
            }
            
            // Reconnect the original right subtree
            current.right = tempRight;
        }

        // Flatten the right subtree (this happens after the left subtree is handled)
        flatten(root.right);
    }
}
