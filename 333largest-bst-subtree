public class Solution {
    public TreeNode largestBSTSubtree(TreeNode root) {
        return helper(root).node;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int size = left.size + right.size + 1;
            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);
            return new Result(root, size, min, max);
        } else {
            return new Result(null, Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    private static class Result {
        TreeNode node;
        int size;
        int min;
        int max;
        boolean isBST;

        Result(TreeNode node, int size, int min, int max) {
            this.node = node;
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = true;
        }
    }
}
