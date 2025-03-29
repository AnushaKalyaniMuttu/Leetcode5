public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        // If the tree is empty, return 0
        if (root == null) {
            return 0;
        }
        
        // Recursively compute the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The depth of the current node is 1 + the maximum of the left and right depths
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = sol.maxDepth(root);
        System.out.println(depth);  // Output: 3
    }
}
