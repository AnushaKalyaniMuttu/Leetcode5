// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    // Helper function to build the tree
    private TreeNode buildTree(int[] nums, int start, int end) {
        // Base case: if the range is invalid, return null
        if (start > end) {
            return null;
        }

        // Find the middle element
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left subtree and right subtree
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);

        return root;
    }
}
