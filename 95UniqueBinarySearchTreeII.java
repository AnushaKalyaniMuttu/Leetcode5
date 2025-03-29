import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class UniqueBinarySearchTreeII95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        
        // If start is greater than end, add a null node
        if (start > end) {
            trees.add(null);
            return trees;
        }

        // Iterate through all possible root values
        for (int i = start; i <= end; i++) {
            // Generate all possible left and right subtrees
            List<TreeNode> leftSubtrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubtrees = generateTrees(i + 1, end);

            // Combine each left and right subtree with the current root
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<TreeNode> trees = sol.generateTrees(3);
        System.out.println("Number of unique BSTs: " + trees.size());
        // Optionally, you can add code to print each tree structure
    }
}

/*
Complexity Analysis
•	Time Complexity: The time complexity is roughly O(4^n / n^{3/2})), which is related to the Catalan numbers, representing the number of unique BSTs for n. nodes.
•	Space Complexity: The space complexity is O(n) for the recursion stack, plus the space needed to store the list of trees.
*/
