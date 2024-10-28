public class MaximumSubArray53 {
    public int maxSubArray(int[] nums) {
        // Initialize the first element
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update maxCurrent
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            // Update maxGlobal
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }
}
