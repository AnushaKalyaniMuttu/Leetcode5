import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return; // Exceeded the target
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates
            }
            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i + 1); // Move to next index
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> combinations = cs.combinationSum2(candidates, target);
        System.out.println("Combinations that sum to " + target + ": " + combinations);
    }
}


/*

Explanation of the Code
•	Sorting the Candidates: The array is sorted to facilitate the skipping of duplicates.
•	Backtracking: The backtrack function recursively explores combinations. When a combination matches the target, it's added to the result list.
•	Skipping Duplicates: The condition if (i > start && candidates[i] == candidates[i - 1]) ensures that we skip over duplicate values at the same depth of recursion, preventing duplicate combinations in the output.
Time Complexity (TC) and Space Complexity (SC)
Time Complexity (TC)
•	The time complexity can be analyzed based on how many combinations we need to explore:
o	In the worst case, for nnn candidates, we could generate up to 2n2^n2n combinations.
o	However, due to the constraints (only unique combinations) and skipping duplicates, the average case is often much better, especially when there are many duplicates.
•	Overall, a more precise estimate can be given as: O(2n)O(2^n)O(2n) where nnn is the number of candidates, with a significant reduction in practice due to the duplicate handling.
Space Complexity (SC)
•	The space complexity is determined by:
o	Call Stack: In the worst case, the depth of recursion can be O(n)O(n)O(n), where nnn is the number of candidates.
o	Result Storage: The space to store the results can also grow based on the number of unique combinations found, which can be up to O(2n)O(2^n)O(2n) in the worst case.
Thus, the space complexity can be summarized as:
O(n)+O(number of unique combinations)O(n) + O(\text{number of unique combinations})O(n)+O(number of unique combinations)
Summary
•	Time Complexity: O(2n)O(2^n)O(2n) (with optimizations due to duplicate handling)
•	Space Complexity: O(n)+O(number of unique combinations)O(n) + O(\text{number of unique combinations})O(n)+O(number of unique combinations)

  */
