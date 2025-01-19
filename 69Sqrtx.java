class Sqrtx69 {
      public int mySqrt(int x) {
        if (x < 2) return x; // Handle 0 and 1
        
        int left = 2, right = x / 2; // Start the binary search range

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            long squared = (long) mid * mid; // Use long to prevent overflow

            if (squared == x) {
                return mid; // Perfect square case
            } else if (squared < x) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }
        
        return right; // right is the integer square root
    }
}


/*
Time and Space Complexity
•	Time Complexity: O(log x), since the search space is halved with each iteration.
•	Space Complexity: O(1), because we only use a few variables for tracking indices and the midpoint.

  */
