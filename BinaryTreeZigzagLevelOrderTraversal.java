import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean leftToRight = true; // Direction flag

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node;
                if (leftToRight) {
                    node = deque.pollFirst(); // Left to right
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                } else {
                    node = deque.pollLast(); // Right to left
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
                
                currentLevel.add(node.val);
            }
            
            result.add(currentLevel);
            leftToRight = !leftToRight; // Flip the direction
        }
        
        return result;
    }
}
/*
Complexity:
Time Complexity: O(n), where n is the number of nodes, as each node is processed once.
Space Complexity: O(n), for the result list and the deque that holds the nodes.
  */
