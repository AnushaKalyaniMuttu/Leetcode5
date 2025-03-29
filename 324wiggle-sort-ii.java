import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Create a new array to store the result
        int[] result = new int[nums.length];
        
        // Step 3: Use two pointers to interlace the elements
        int mid = (nums.length - 1) / 2; // Get the middle index
        int i = mid;  // Start from the middle of the sorted array for the smaller half
        int j = nums.length - 1; // Start from the end of the sorted array for the larger half
        
        // Step 4: Fill the result array alternately from the two halves
        for (int k = 0; k < nums.length; k++) {
            if (k % 2 == 0) {
                result[k] = nums[i--];  // Place smaller elements at even indices
            } else {
                result[k] = nums[j--];  // Place larger elements at odd indices
            }
        }

        // Step 5: Copy the result back into the original array
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
