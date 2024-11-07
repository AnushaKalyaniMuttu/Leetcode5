private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex = 0;  // Tracks the current index in preorder list

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a map of value to index for inorder traversal
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        // Call the helper function with initial boundaries
        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        // Base case: if there is no node to process
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root in the inorder array
        int rootInorderIndex = inorderIndexMap.get(rootVal);

        // Number of nodes in the left subtree
        int leftSubtreeSize = rootInorderIndex - inStart;

        // Recursively build the left subtree
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inStart, rootInorderIndex - 1);
        
        // Recursively build the right subtree
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, rootInorderIndex + 1, inEnd);
        
        return root;
    }
