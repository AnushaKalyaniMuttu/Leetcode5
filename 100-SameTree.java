class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, they are the same
        if (p == null && q == null) {
            return true;
        }
        // If one of the nodes is null or values are different, they are not the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example: Create two identical trees
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        // Example: Create two different trees
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);
        p2.right = new TreeNode(1);

        TreeNode q2 = new TreeNode(1);
        q2.left = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println("Are trees p1 and q1 the same? " + sol.isSameTree(p1, q1)); // Output: true
        System.out.println("Are trees p2 and q2 the same? " + sol.isSameTree(p2, q2)); // Output: false
    }
}

/*
Complexity Analysis
•	Time Complexity: O(N) where N is the number of nodes in the trees, since we potentially visit every node.
•	Space Complexity: O(H) where H is the height of the tree due to the recursion stack.

  */
