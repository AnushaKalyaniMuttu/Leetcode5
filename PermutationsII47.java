import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to facilitate skipping duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add a copy of the current permutation
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // Skip if already used
            
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue; // Only use the first occurrence of this number
            }
            
            used[i] = true; // Mark the number as used
            tempList.add(nums[i]); // Add the number to the current permutation

            backtrack(result, tempList, nums, used); // Recur

            // Backtrack
            tempList.remove(tempList.size() - 1);
            used[i] = false; // Mark the number as unused
        }
    }

    public static void main(String[] args) {
        UniquePermutations up = new UniquePermutations();
        
        // Example 1
        int[] nums1 = {1, 1, 2};
        System.out.println(up.permuteUnique(nums1)); // Output: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]

        // Example 2
        int[] nums2 = {1, 2, 3};
        System.out.println(up.permuteUnique(nums2)); // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}


/*
Explanation
Sorting: The array is sorted at the beginning to group duplicates together, making it easier to skip them.

Backtracking Method:

Base Case: When the size of the temporary list equals the size of the input array, we add a copy of it to the result list.
Loop: Iterate through each element in nums.
Skip Used Elements: If an element has been used in the current permutation, we skip it.
Skip Duplicates: We check if the current element is a duplicate (i.e., it is the same as the previous element) and ensure that the previous duplicate has not been used in this recursive path.
Recursive Call: We mark the element as used and add it to the current permutation, then recursively call the backtracking method.
Backtrack: After exploring all options starting with the current number, we remove it from the temporary list and mark it as unused.
Complexity
Time Complexity: O(n! * n) for generating all unique permutations, where n is the length of the input array.
Space Complexity: O(n) for the temporary list and the boolean array used for tracking

  */
