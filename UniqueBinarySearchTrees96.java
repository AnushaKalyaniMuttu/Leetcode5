public class UniqueBinarySearchTrees96 {
    public int numTrees(int n) {
        if (n <= 0) return 0;

        // dp[i] will hold the number of unique BSTs that can be formed with i nodes
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty tree
        dp[1] = 1; // Base case: one node

        // Fill the dp array
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                int leftSubtrees = dp[root - 1]; // Number of left subtrees
                int rightSubtrees = dp[nodes - root]; // Number of right subtrees
                dp[nodes] += leftSubtrees * rightSubtrees;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 3;
        int result = sol.numTrees(n);
        System.out.println("Number of unique BSTs for n = " + n + ": " + result); // Output: 5
    }
}
/*
Complexity Analysis
•	Time Complexity: O(n^2) because for each number of nodes nnn, we are iterating through all possible roots.
•	Space Complexity: O(n) for the dynamic programming array.

*/
