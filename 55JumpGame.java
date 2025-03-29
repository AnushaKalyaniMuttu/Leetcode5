public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReachable = 0; // Maximum index we can reach
        for (int i = 0; i < nums.length; i++) {
            // If we can't reach this index, return false
            if (i > maxReachable) {
                return false;
            }
            // Update the maximum reachable index
            maxReachable = Math.max(maxReachable, i + nums[i]);
            // If we can reach or exceed the last index, return true
            if (maxReachable >= nums.length - 1) {
                return true;
            }
        }
        return false; // If we exit the loop, we can't reach the last index
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jg.canJump(nums)); // Output: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(jg.canJump(nums2)); // Output: false
    }
}



/*
Explanation
Initialization: We start by initializing maxReachable, which tracks the farthest index we can reach.
Iterate through the array: For each index i:
If i is greater than maxReachable, it means we can't reach this index, so we return false.
Update maxReachable to the maximum of its current value and i + nums[i].
If at any point maxReachable is greater than or equal to the last index, we return true.
Return false: If we finish the loop and haven't reached the last index, we return false.
Complexity
Time Complexity: O(n), where n is the length of the array.
Space Complexity: O(1), since we're using only a few variables.
*/
