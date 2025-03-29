class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;  // Initialize each node as its own parent
        
        int count = n;  // Start with n components
        for (int[] edge : edges) {
            if (union(edge[0], edge[1], parent)) count--;  // Merge components if needed
        }
        return count;
    }
    
    private int find(int x, int[] parent) {
        if (parent[x] != x) 
            parent[x] = find(parent[x], parent);  // Path compression
        return parent[x];
    }
    
    private boolean union(int x, int y, int[] parent) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX != rootY) {
            parent[rootX] = rootY;  // Merge two components
            return true;
        }
        return false;
    }
}
