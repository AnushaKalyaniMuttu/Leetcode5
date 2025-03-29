import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        // Precompute factorials
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        
        // Adjust k to be zero-based
        k--; 
        
        // List of numbers to get permutation from
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        StringBuilder permutation = new StringBuilder();
        
        // Build the k-th permutation
        for (int i = 0; i < n; i++) {
            int index = k / factorials[n - 1 - i];
            permutation.append(numbers.get(index));
            numbers.remove(index);
            k %= factorials[n - 1 - i];
        }
        
        return permutation.toString();
    }
}
/*
time complexity of O(n^2)and a space complexity of O(n)
  */
