class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true; // An empty node is a valid BST
        }

        int val = node.val;

        // Check the bounds
        if ((lower != null && val <= lower) || (upper != null && val >= upper)) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isValidBST(node.left, lower, val) && isValidBST(node.right, val, upper);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example: Create a valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        // Example: Create an invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println("Is valid BST (root1): " + sol.isValidBST(root1)); // Output: true
        System.out.println("Is valid BST (root2): " + sol.isValidBST(root2)); // Output: false
    }
}

/*
•  Time Complexity: O(N), where N is the number of nodes in the tree, since each node is visited once.
•  Space Complexity: O(H), where H is the height of the tree, due to the recursive stack space. In the worst case (for an unbalanced tree), this could be O(N)

    */
