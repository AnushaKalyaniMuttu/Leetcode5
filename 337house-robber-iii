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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] result = robSub(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robSub(TreeNode node) {
        // Return an array where:
        // result[0] = max amount we can rob if the current node is not robbed
        // result[1] = max amount we can rob if the current node is robbed
        if (node == null) {
            return new int[2];  // [0, 0] if the node is null
        }

        // Recursively solve for left and right children
        int[] left = robSub(node.left);
        int[] right = robSub(node.right);

        // If we do not rob the current node, we can take the maximum value of robbing or not robbing its children
        int robNotThisNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        // If we rob the current node, we cannot rob its children, so we add its value with the result of its grandchildren
        int robThisNode = node.val + left[0] + right[0];

        return new int[]{robNotThisNode, robThisNode};
    }
}
