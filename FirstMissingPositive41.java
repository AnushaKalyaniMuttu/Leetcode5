public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Clean the input by replacing non-positive numbers and numbers larger than n
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1; // Replace with a number outside the range
            }
        }

        // Step 2: Use the index as a hash map to mark numbers as seen
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]); // Get the absolute value
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); // Mark as seen
            }
        }

        // Step 3: Find the first index that has a positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; // The missing positive is i + 1
            }
        }

        return n + 1; // If all indices are marked, return n + 1
    }

    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        System.out.println("The first missing positive is: " + solution.firstMissingPositive(nums));
    }
}
