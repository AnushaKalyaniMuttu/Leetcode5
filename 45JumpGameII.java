public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int jumps = 0; // Number of jumps made
        int currentEnd = 0; // The farthest point that can be reached with current jumps
        int farthest = 0; // The farthest point that can be reached with next jumps

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point we can reach
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++; // We need to make a jump
                currentEnd = farthest; // Update the end for the next jump
            }
        }
        
        return jumps;
    }
}

/*
Time and Space Complexity
•	Time Complexity: O(n), where n is the length of the input array. We traverse the array once.
•	Space Complexity: O(1), since we are using a constant amount of space.

  */
