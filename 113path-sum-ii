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
      public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, sum, currentPath, result);
        return result;
    }

    private void findPaths(TreeNode node, int sum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add the current node to the path
        currentPath.add(node.val);

        // If it's a leaf node, check if the path sum matches the target sum
        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new ArrayList<>(currentPath));  // Add a copy of the current path to the result
        } else {
            // Recurse down to the left and right subtrees with the updated sum
            findPaths(node.left, sum - node.val, currentPath, result);
            findPaths(node.right, sum - node.val, currentPath, result);
        }

        // Backtrack: remove the current node from the path before returning
        currentPath.remove(currentPath.size() - 1);
    }
}
