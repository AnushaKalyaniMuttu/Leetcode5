import java.util.Arrays;

public class 3SumCloset16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first three elements

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Left pointer
            int right = nums.length - 1; // Right pointer

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Update closestSum if the current sum is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move the pointers based on comparison with the target
                if (sum < target) {
                    left++; // Increase the sum
                } else if (sum > target) {
                    right--; // Decrease the sum
                } else {
                    // Exact match found
                    return sum;
                }
            }
        }

        return closestSum; // Return the closest sum found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums, target)); // Output: 2
    }
}
