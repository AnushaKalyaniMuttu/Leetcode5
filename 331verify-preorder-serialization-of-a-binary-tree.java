public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1; // Start with one available slot for the root
        
        for (String node : nodes) {
            diff--; // One slot is used for the current node
            
            if (diff < 0) {
                return false; // If no slot is available for a node, it's invalid
            }
            
            if (!node.equals("#")) {
                diff += 2; // Non-null node creates two new slots
            }
        }
        
        return diff == 0; // All slots should be filled by the end
    }
}
