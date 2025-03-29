import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
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
            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i); // Allow the same number to be used
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = cs.combinationSum(candidates, target);
        System.out.println("Combinations that sum to " + target + ": " + combinations);
    }
}


/*

Explanation of the Code
•	Backtracking Approach: The method backtrack explores all combinations. When the current combination sums to the target, it's added to the result. If the sum exceeds the target, it stops further exploration down that path.
•	Reusing Candidates: The loop allows the same candidate to be used multiple times, which is necessary for this problem.
Time Complexity (TC) and Space Complexity (SC)
Time Complexity (TC)
•	The time complexity can be complex to analyze due to the nature of combinations. In the worst case, you may explore all combinations of candidates.
•	Each candidate can be chosen multiple times, leading to an exponential number of possibilities. Thus, the time complexity can be approximated as: O(target×ntarget/min(candidates))O(\text{target} \times \text{n}^{\text{target}/\text{min(candidates)}})O(target×ntarget/min(candidates)) where nnn is the number of candidates. This reflects the branching factor of choosing candidates multiple times.
Space Complexity (SC)
•	The space complexity is driven by the depth of the recursion and the space used to store results:
o	Call Stack: In the worst case, the depth of the recursion can be O(target/min(candidates))O(\text{target}/\text{min(candidates)})O(target/min(candidates)).
o	Result Storage: The storage for results can also grow exponentially in the number of combinations found.
Overall, the space complexity can be considered:
O(target/min(candidates))O(\text{target}/\text{min(candidates)})O(target/min(candidates))
for the call stack, plus the space needed to store the results.
Summary
•	Time Complexity: O(target×ntarget/min(candidates))O(\text{target} \times n^{\text{target}/\text{min(candidates)}})O(target×ntarget/min(candidates))
•	Space Complexity: O(target/min(candidates))+O(number of combinations)O(\text{target}/\text{min(candidates)}) + O(\text{number of combinations})O(target/min(candidates))+O(number of combinations)


  */
