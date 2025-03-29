import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current)); // Add the current subset

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]); // Include the current element
            backtrack(result, current, nums, i + 1); // Recur with the next index
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);
        
        // Print the result
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
        // Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }
}
/*
Complexity
Time Complexity: O(2^n) in the worst case, where n is the number of elements in nums. Each element can either be included or excluded.
Space Complexity: O(n) for the recursion stack and O(2^n) for storing the results.
  */
