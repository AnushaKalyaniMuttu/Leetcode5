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


/*


Explanation of the Code
1.	Input Cleaning: First, we replace all non-positive numbers and numbers greater than n (the size of the array) with n+1. This simplifies further processing.
2.	Index Marking: For each number in the array, we mark its presence by using its value as an index. We negate the value at the index corresponding to the absolute value of the number (adjusting for 1-based indexing).
3.	Finding the First Missing Positive: After marking, we check the array for the first index that contains a positive number. The index represents the missing positive integer.
4.	Return Value: If all indices contain negative values, it indicates that the numbers 1 through n are present, so we return +1.
Time Complexity (TC) and Space Complexity (SC)
Time Complexity (TC)
•	The algorithm makes a constant number of passes over the array:
o	First pass: Clean the input: O(n)
o	Second pass: Mark the indices: O(n)
o	Third pass: Check for the first missing positive: O(n)
Overall, the time complexity is:
O(n)
Space Complexity (SC)
•	The solution operates in constant space, using the input array itself for marking. Thus, the space complexity is:
O(1)
Summary
•	Time Complexity: O(n)
•	Space Complexity:O(1)


  */
