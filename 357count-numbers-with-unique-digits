class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1; // Only one number: 0
        }
        
        int count = 1; // Start with 0 as a valid number
        int availableDigits = 9;
        int currentCombination = 9;

        for (int i = 1; i <= n; i++) {
            count += currentCombination;
            if (i == n || availableDigits == 0) {
                break;
            }
            currentCombination *= availableDigits; // Multiply for unique combinations
            availableDigits--; // One less digit available
        }
        
        return count;
    }
}
