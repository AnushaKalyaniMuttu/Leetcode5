class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class RecoverBinarySearchTree99 {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // Perform the in-order traversal
        inorderTraversal(root);
        // Swap the values of the two nodes found
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorderTraversal(node.left);
        
        // Identify the nodes that are swapped
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev; // First violation
            }
            second = node; // Second violation
        }
        
        prev = node; // Update the previous node
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example: Create a BST with swapped nodes
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        sol.recoverTree(root);
        // Now the tree should be corrected

        // You can add a method to print the tree or check the values to verify recovery
    }
}

/*

Complexity Analysis
•	Time Complexity: O(N), where N is the number of nodes in the tree, since we perform a single traversal.
•	Space Complexity: O(H), where H is the height of the tree due to the recursion stack.

*/
