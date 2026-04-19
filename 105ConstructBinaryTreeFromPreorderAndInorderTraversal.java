import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootInorderIndex = inorderIndexMap.get(rootVal);

        int leftSize = rootInorderIndex - inStart;

        root.left = buildTreeHelper(preorder,
                preStart + 1,
                preStart + leftSize,
                inStart,
                rootInorderIndex - 1);

        root.right = buildTreeHelper(preorder,
                preStart + leftSize + 1,
                preEnd,
                rootInorderIndex + 1,
                inEnd);

        return root;
    }
}
