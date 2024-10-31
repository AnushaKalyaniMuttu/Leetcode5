public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length; // No duplicates to remove

        int index = 2; // Start from the third position in the array

        for (int i = 2; i < nums.length; i++) {
            // Check if the current number is not a duplicate of the last two
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i]; // Place it in the next position
                index++; // Move to the next position
            }
        }

        return index; // The new length of the modified array
    }

    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int newLength = solution.removeDuplicates(nums);
        
        // Print the modified array
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        // Output: 1 1 2 2 3
    }
}
/*
Time Complexity
The time complexity is O(n), where n is the length of the input array, as we traverse the array once.

Space Complexity
The space complexity is O(1) since we are modifying the array in place without using any additional data structures.
  */
