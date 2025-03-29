import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Process the node
            current = stack.pop();
            result.add(current.val);
            // Move to the right node
            current = current.right;
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        Solution sol = new Solution();
        List<Integer> traversal = sol.inorderTraversal(root);
        System.out.println(traversal); // Output: [1, 3, 2]
    }
}

/*
Complexity Analysis
•	Time Complexity: O(N), where N is the number of nodes in the tree since each node is processed exactly once.
•	Space Complexity: O(H), where H is the height of the tree. This space is used by the stack for the iterative approach and the recursion stack for the recursive approach.
*/
