public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int j = 0; // Pointer for the position of the next valid element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) { // If the current element is not the value to remove
                nums[j] = nums[i]; // Update the next position with the current valid element
                j++; // Move to the next position
            }
        }

        return j; // Length of the valid elements
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        
        int[] nums = {3, 2, 2, 3, 4, 5};
        int val = 3;
        int newLength = solution.removeElement(nums, val);
        
        // Print the valid elements
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
o	O(1)  The operation is done in place, so no additional space proportional to the input size is used.
Summary
This two-pointer technique efficiently removes all instances of a specified value from an array with:
•	Optimal Time Complexity: O(N)
•	Optimal Space Complexity: O(1)

  */
