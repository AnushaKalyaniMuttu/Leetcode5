import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Make a copy of the current permutation
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue; // Skip already used numbers
                used[i] = true; // Mark the number as used
                tempList.add(nums[i]); // Add it to the current permutation
                
                backtrack(result, tempList, nums, used); // Recur
                
                // Backtrack: remove the number and mark it as unused
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permutations.permute(nums);
        System.out.println(result); // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}
/*
Explanation
1.	Method permute: This is the main method that initializes the result list and starts the backtracking process.
2.	Backtracking Method:
o	Base Case: If the size of tempList equals the length of nums, we have a complete permutation, and we add it to result.
o	Loop: Iterate through each number in nums. If the number is already used (tracked by the used array), skip it.
o	Recursive Call: Mark the number as used, add it to tempList, and call backtrack recursively to build the next level of the permutation.
o	Backtrack: After exploring the current path, remove the last number from tempList and mark it as unused to explore other possibilities.
Time and Space Complexity
•	Time Complexity: O(n * n!) because there are n! permutations of n elements, and constructing each permutation takes O(n) time.
•	Space Complexity: O(n) for the tempList and used array used during recursion.

*/
