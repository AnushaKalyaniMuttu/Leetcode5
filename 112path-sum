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
      public boolean hasPathSum(TreeNode root, int sum) {
        // If the root is null, there's no path, so return false
        if (root == null) {
            return false;
        }

        // Check if we've reached a leaf node and the sum matches
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        // Recurse down the left and right children with the updated sum
        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
