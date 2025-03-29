public class RemoveDuplicatesFromSortedArray26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 1; // Pointer for the position of the next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // If current element is different from the last unique
                nums[j] = nums[i]; // Update the next position with the current unique element
                j++; // Move to the next position
            }
        }

        return j; // Length of the unique elements
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = solution.removeDuplicates(nums);
        
        // Print the unique elements
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nNew length: " + newLength);
    }
}


/*


Complexity Analysis
•	Time Complexity:
o	O(N), where N is the number of elements in the array. We make a single pass through the array.
•	Space Complexity:
o	O(1). The operation is done in place, so no additional space proportional to the input size is used.
Summary
This two-pointer technique effectively removes duplicates from a sorted array with:
•	Optimal Time Complexity: O(N)
•	Optimal Space Complexity: O(1)
*/
